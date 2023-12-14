package com.legends.edumia.client.gui.map;

import com.legends.edumia.Edumia;
import com.legends.edumia.client.gui.EdumiaDimManuScreen;
import com.legends.edumia.worldgen.biome.EdumiaBiome;
import com.legends.edumia.worldgen.biome.EdumiaBiomesData;
import com.legends.edumia.worldgen.dimension.EdumiaDimensions;
import com.legends.edumia.worldgen.gen.map.MapImageLoader;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector2i;

import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class EdumiaMapScreen extends EdumiaDimManuScreen {

    private static final ResourceLocation MAP_ICON_TEXTURE = new ResourceLocation(Edumia.MODID, "textures/map/screen.png");
    private static final ResourceLocation MAP_UI_TEXTURE = new ResourceLocation(Edumia.MODID, "textures/map/map_ui.png");
    private static final ResourceLocation MAP_TEXTURE = new ResourceLocation(Edumia.MODID, "textures/map/edumia_map.png");

    private static final Component MAP_TITLE_TEXT = Component.nullToEmpty("Edumia Map");

    private boolean hasOverlay;
    public static final int MARGIN = 5;

    public static final int MAP_IMAGE_WIDTH = 1200;
    public static final int MAP_IMAGE_HEIGHT = 900;
    public int windowWidth, windowHeight;
    public int mapWindowWidth, mapWindowHeight;
    public float minZoom;
    public static final int MAX_ZOOM_LEVEL = 10;
    public static final float[] ZOOM_LEVELS = new float[MAX_ZOOM_LEVEL];

    public static final Vector2i WORLD_SIZE = getWorldSize();

    private static int mapDisplacementX = 0;
    private static int mapDisplacementY = 0;

    private static int zoomLevel = 1;

    private static int zoomButtonIndex;
    private static int dezoomButtonIndex;
    private static int centerOnPlayerButtonIndex;
    private static int debugButtonIndex;
    private Vec3 playerCoordinate;

    private Vector2i cursorWorldCoordinate;

    private Vec3 playerCoordinates;
    private static boolean debug = false;
    AbstractClientPlayer player;


    public EdumiaMapScreen() {
        super(MAP_TITLE_TEXT);
        float zoom = 1;
        for (int i = 0; i < ZOOM_LEVELS.length; i++){
            ZOOM_LEVELS[i] = zoom;
            zoom += 1.2f;
        }
    }

    @Override
    public void init() {
        if (this.minecraft != null){
            float[] guiScaleModifiers = {// Index is GUI scale
                    6.25f, //0
                    3f,//1
                    4f,//2
                    5f,//3
                    6.25f//4
            };

            int guiScale = this.minecraft.options.guiScale().get();

            windowWidth = Math.round((float)MAP_IMAGE_WIDTH / guiScaleModifiers[guiScale]);
            windowHeight = Math.round((float)MAP_IMAGE_HEIGHT / guiScaleModifiers[guiScale]);

            mapWindowWidth = windowWidth - (MARGIN * 2);
            mapWindowHeight = windowHeight - (MARGIN * 2);
        }

        minZoom = (float) mapWindowWidth / MAP_IMAGE_WIDTH;

        int x = (this.width - windowWidth) / 2;
        int y = (this.height - windowHeight) / 2;

        int offset = 10;
        int buttonMargin = 3;
        int optionsOffsetX = x + windowWidth + 2;
        int optionsOffsetY = y + windowHeight - MARGIN;



        Button debugButton = Button.builder(Component.literal("Debug"), button -> {
                    debug = !debug;
                })
                .bounds(optionsOffsetX, y + MARGIN, 18, 18).build();


        Button centerOnPlayer = Button.builder(Component.literal("Center on Player"), button -> {
                    centerOnCoordinates(playerCoordinate.x, playerCoordinate.z);
                })
                .bounds(optionsOffsetX, optionsOffsetY - (offset * 3) - (buttonMargin * 2), 18, 18).build();

        Button zoomButton = Button.builder(Component.literal("Zoom"), button -> {
                    zoom(1, false);
                })
                .bounds(optionsOffsetX, optionsOffsetY - (offset * 2)  - buttonMargin, 18, 18).build();
        Button dezoomButton = Button.builder(Component.literal("Dezoom"), button -> {
                    zoom(-1, false);
                })
                .bounds(optionsOffsetX, optionsOffsetY - offset, 18, 18).build();

        addRenderableWidget(debugButton);
        addRenderableWidget(centerOnPlayer);
        addRenderableWidget(zoomButton);
        addRenderableWidget(dezoomButton);

        debugButtonIndex = children().indexOf(debugButton);
        centerOnPlayerButtonIndex = children().indexOf(centerOnPlayer);
        zoomButtonIndex = children().indexOf(zoomButton);
        dezoomButtonIndex = children().indexOf(dezoomButton);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        Entity cameraEntity = this.minecraft.getCameraEntity();
        if (cameraEntity != null){
            if (cameraEntity instanceof AbstractClientPlayer abstractClientPlayer){
                this.player = abstractClientPlayer;
                this.renderBackground(graphics);
                this.drawWindow(graphics, mouseX, mouseY);
            }else{
                this.player = null;
            }
        }
    }

    public void drawWindow(GuiGraphics context, int mouseX, int mouseY) {
        int x = (this.width -  windowWidth) / 2;
        int y = (this.height - windowHeight) / 2;
        RenderSystem.enableBlend();

        drawMaintTextures(context, x, y, mouseX, mouseY);
        Vec2 mapPlayerPos = getCoordinateOnMap((float)player.blockPosition().getX(), (float)player.blockPosition().getZ(), 4,4);
        if(this.player.level().dimension().location().toString().contains(EdumiaDimensions.EDUMIA_KEY.location().toString())){
            context.blit(this.player.getSkinTextureLocation(),
                    x + MARGIN + (int)mapPlayerPos.x - 4,
                    y + MARGIN + (int)mapPlayerPos.y - 4,
                    8, 8, 8, 8, 64, 64);

            boolean oustideBound = cursorIsOutsideOfMapBounds(mouseX, mouseY);
            cursorWorldCoordinate = getWorldCoordinateOfCursor(mouseX, mouseY);

            // Debug panel
            if(debug){
                Level world = this.player.level();
                Optional<ResourceKey<Biome>> biomeRegistry = world.getBiome(this.player.blockPosition()).unwrapKey();
                String currentBiomeId = biomeRegistry.isPresent() ? biomeRegistry.get().location().toString() : "N/A";

                context.drawString(font, Component.literal("Player information"), 0, 5, 0xffffff);
                BlockPos playerPos = this.player.blockPosition();
                context.drawString(font, Component.literal("Coordinates : " + (int)playerPos.getX() + ", " + (int)playerPos.getY() + ", " + (int)playerPos.getZ()), 5, 15, 0xffffff);
                context.drawString(font, Component.literal("Biome : " + currentBiomeId), 5, 25, 0xffffff);

                EdumiaBiome meBiome = EdumiaBiomesData.biomeMap.get(MapImageLoader.getBiomeColor(cursorWorldCoordinate.x, cursorWorldCoordinate.y));

                context.drawString(font, Component.literal("Cursor information"), 0, 45, 0xffffff);
                context.drawString(font, Component.literal("Coordinates : " + ((oustideBound) ? "N/A" : (int)cursorWorldCoordinate.x + ", " + EdumiaDimensions.getHighestYAtXZ(mouseX, mouseY) + ", "+ (int)cursorWorldCoordinate.y)), 5, 55, 0xffffff);
                context.drawString(font, Component.literal("Biome : " + ((oustideBound || meBiome == null) ? "N/A" : meBiome.biome.location().toString())), 5, 65, 0xffffff);

                if(!oustideBound && this.player.isCreative()){
                    context.drawString(font, Component.literal("Right Click to teleport"), mouseX + 10, mouseY, 0xcccccc);
                }
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if(button == 1){
            if(!cursorIsOutsideOfMapBounds(mouseX, mouseY)){
                if(this.player.isCreative() && debug){
                    teleport(getWorldCoordinateOfCursor(mouseX, mouseY));
                    this.onClose();
                    return true;
                }
            }
        }
        super.mouseClicked(mouseX, mouseY, button);
        return false;
    }

    private void teleport(Vector2i coord){
        this.player.setPos(coord.x, this.player.getY(), coord.y);
    }

    private float getZoomLevel(){
        return ZOOM_LEVELS[zoomLevel - 1];
    }

    private void drawMaintTextures(GuiGraphics context, int x, int y, double mouseX, double mouseY) {
        // Border
//        context.blit(WINDOW_TEXTURE, x, y, 0, 0,  windowWidth, windowHeight,
//                windowWidth, windowHeight);
        // Map
        context.blit(MAP_TEXTURE, x + MARGIN, y + MARGIN,
                // UV (x,y)
                mapDisplacementX, mapDisplacementY,
                mapWindowWidth,
                mapWindowHeight,
                (int) (MAP_IMAGE_WIDTH * getZoomLevel() * minZoom),
                (int) (MAP_IMAGE_HEIGHT * getZoomLevel() * minZoom));

        // Map UI

        // Debug Button
        int debugButtonTextureOffset = children().get(debugButtonIndex).isMouseOver(mouseX, mouseY) ? 18 : 0;

        context.blit(MAP_UI_TEXTURE,
                ((Button)children().get(debugButtonIndex)).getX(),
                ((Button)children().get(debugButtonIndex)).getY(),
                debugButtonTextureOffset, 54, 18, 18, 256, 256);

        // Center on player
        int centerOnPlayerTextureOffset = children().get(centerOnPlayerButtonIndex).isMouseOver(mouseX, mouseY) ? 18 : 0;
        if(zoomLevel == 1){
            centerOnPlayerTextureOffset = 36;
        }
        context.blit(MAP_UI_TEXTURE,
                ((Button)children().get(centerOnPlayerButtonIndex)).getX(),
                ((Button)children().get(centerOnPlayerButtonIndex)).getY(),
                centerOnPlayerTextureOffset, 36, 18, 18, 256, 256);

        // Zoom +
        int zoomTextureOffset = children().get(zoomButtonIndex).isMouseOver(mouseX, mouseY) ? 18 : 0;
        if(zoomLevel ==  MAX_ZOOM_LEVEL - 1){
            zoomTextureOffset = 36;
        }
        context.blit(MAP_UI_TEXTURE,
                ((Button)children().get(zoomButtonIndex)).getX(),
                ((Button)children().get(zoomButtonIndex)).getY(),
                zoomTextureOffset, 0, 18, 18, 256, 256);

        // Zoom -
        int dezoomTextureOffset = children().get(dezoomButtonIndex).isMouseOver(mouseX, mouseY) ? 18 : 0;
        if(zoomLevel == 1){
            dezoomTextureOffset = 36;
        }
        context.blit(MAP_ICON_TEXTURE,
                ((Button)children().get(dezoomButtonIndex)).getX(),
                ((Button)children().get(dezoomButtonIndex)).getY(),
                dezoomTextureOffset, 18, 18, 18, 256, 256);

        ((Button)children().get(centerOnPlayerButtonIndex)).active = (zoomLevel > 1);
        ((Button)children().get(zoomButtonIndex)).active = (zoomLevel < MAX_ZOOM_LEVEL - 1);
        ((Button)children().get(dezoomButtonIndex)).active = (zoomLevel > 1);


        // BREE (TEST)
        /*
        Vec2f breeOnMap = getCoordinateOnMap(4100.0f, 2550.0f, 2,2);
        context.drawTexture(MAP_UI_TEXTURE,
                x + MARGIN + (int)breeOnMap.x,
                y + MARGIN + (int)breeOnMap.y,
                54, 0, 4, 4, 256, 256);
        context.drawText(textRenderer,"BREE",
                x + MARGIN + (int)breeOnMap.x + 5,
                y + MARGIN + (int)breeOnMap.y - 2,
                0x000000,
                false);
         */

    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (button != 0) {
            return false;
        }
        if(cursorIsOutsideOfMapBounds(mouseX, mouseY))
            return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);

        mapDisplacementX -= (float) deltaX;
        mapDisplacementY -= (float) deltaY;

        correctMapVision();
        return true;
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        if(!cursorIsOutsideOfMapBounds(mouseX, mouseY)){
            cursorWorldCoordinate = getWorldCoordinateOfCursor(mouseX, mouseY);
            zoom((int)Math.round(amount), true);
        }
        return super.mouseScrolled(mouseX, mouseY, amount);
    }

    private void zoom(int amount, boolean towardCursor){
        int newZoomLevelIndex = (int)Math.min(MAX_ZOOM_LEVEL - 1, Math.max(1, (zoomLevel + amount)));
        if(newZoomLevelIndex != zoomLevel) {
            Vector2i center = (towardCursor) ? cursorWorldCoordinate : getCoordinateInCenterOfMap();

            zoomLevel = newZoomLevelIndex;

            centerOnCoordinates(center.x, center.y);
        }
    }

    private void correctMapVision() {
        // Minimum (0)
        mapDisplacementX = Math.max(0, mapDisplacementX);
        mapDisplacementY = Math.max(0, mapDisplacementY);

        float modifier = getZoomLevel() - 1;
        // Maximum (dynamic)
        // When zoomLevelIndex is 0, maximum should be 0,0
        mapDisplacementX = (int)Math.min((mapWindowWidth) * modifier, mapDisplacementX);
        mapDisplacementY = (int) Math.min(( mapWindowHeight) * modifier, mapDisplacementY);
    }

    private Vec2 getCoordinateOnMap(float posX, float posZ, int textureOffsetX, int textureOffsetY) {
        float transformedPosX = ((posX / WORLD_SIZE.x) * mapWindowWidth * getZoomLevel()) - mapDisplacementX;
        float transformedPosY = ((posZ / WORLD_SIZE.y) *  mapWindowHeight * getZoomLevel()) - mapDisplacementY;

        transformedPosX = Math.max(textureOffsetX, Math.min(mapWindowWidth - textureOffsetX, transformedPosX));
        transformedPosY = Math.max(textureOffsetY, Math.min( mapWindowHeight - textureOffsetY, transformedPosY));

        return new Vec2(transformedPosX, transformedPosY);
    }

    private boolean cursorIsOutsideOfMapBounds(double mouseX, double mouseY){
        int x = (this.width -  windowWidth) / 2  + MARGIN;
        int y = (this.height - windowHeight) / 2 + MARGIN;

        boolean isInBoundX = (int)mouseX - x > 0 && (int)mouseX - x < mapWindowWidth;
        boolean isInBoundY = (int)mouseY - y > 0 && (int)mouseY - y <  mapWindowHeight;

        return !isInBoundX || !isInBoundY;
    }

    private void centerOnCoordinates(double x, double y){
        double transformedCoordinatesX = ((x / WORLD_SIZE.x) * mapWindowWidth * getZoomLevel());
        double transformedCoordinatesY = ((y / WORLD_SIZE.y) *  mapWindowHeight * getZoomLevel());

        centerMapTo((int)transformedCoordinatesX, (int)transformedCoordinatesY);
    }

    private Vector2i getCenterOfCurrentMap(){
        int centerX = (int)((mapDisplacementX + (mapWindowWidth / 2)) / (getZoomLevel() * minZoom));
        int centerY =  (int)((mapDisplacementY + ( mapWindowHeight / 2)) / (getZoomLevel() * minZoom));

        return new Vector2i(centerX, centerY);
    }

    private Vector2i getWorldCoordinateOfCursor(double mouseX, double mouseY) {
        mouseX -= (double) (this.width -  windowWidth) / 2;
        mouseY -= (double) (this.height - windowHeight) / 2;

        int centerX = (int)((mapDisplacementX + mouseX) / (getZoomLevel() * minZoom));
        int centerY =  (int)((mapDisplacementY + mouseY) / (getZoomLevel() * minZoom));

        centerX= (int)(WORLD_SIZE.x / MAP_IMAGE_WIDTH * centerX);
        centerY = (int)(WORLD_SIZE.y / MAP_IMAGE_HEIGHT * centerY);

        return new Vector2i(centerX, centerY);
    }


    private Vector2i getCoordinateInCenterOfMap(){
        Vector2i currentCenter = getCenterOfCurrentMap();

        currentCenter.x = (int)(WORLD_SIZE.x / MAP_IMAGE_WIDTH * currentCenter.x);
        currentCenter.y = (int)(WORLD_SIZE.y / MAP_IMAGE_HEIGHT * currentCenter.y);

        return currentCenter;
    }

    private void centerMapTo(int x, int y){
        mapDisplacementX = x - (mapWindowWidth / 2);
        mapDisplacementY = y - ( mapWindowHeight / 2);;

        correctMapVision();
    }

    private static Vector2i getWorldSize(){
        float worldSize = (float) Math.pow(2 , Edumia.MAP_ITERATION);

        return new Vector2i((int)(MAP_IMAGE_WIDTH * worldSize), (int)(MAP_IMAGE_HEIGHT * worldSize));
    }

}


