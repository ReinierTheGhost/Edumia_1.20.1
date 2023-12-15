package com.legends.edumia.worldgen.mapGen.dimension;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.mapGen.chunkgen.EdumiaChunkGenerator;
import com.legends.edumia.worldgen.mapGen.chunkgen.map.EdumiaHeightMap;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraftforge.eventbus.api.IEventBus;
import org.joml.Vector3i;


public class ModDimensions {
    public static final Vector3i ME_SPAWN_LOCATION = new Vector3i(440, 90, 350);
    public static final String PATH = "middle-earth";

    public static final ResourceKey<LevelStem> DIMENSION_KEY =
            ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(Edumia.MODID, PATH));

    public static ResourceKey<Level> WORLD_KEY =
            ResourceKey.create(Registries.DIMENSION, DIMENSION_KEY.location());

    public static void register(IEventBus eventBus) {
        Registry.register(BuiltInRegistries.CHUNK_GENERATOR, new ResourceLocation(Edumia.MODID, PATH), EdumiaChunkGenerator.CODEC);
        WORLD_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(Edumia.MODID, PATH));

        Edumia.LOGGER.debug("Registering ModDimensions for " + Edumia.MODID);
    }

    public static void teleportPlayerToME(Player player) {
        if(!player.level().isClientSide()) {
            ResourceKey<Level> registryKey = player.level().dimension() == WORLD_KEY ? Level.OVERWORLD : WORLD_KEY;
            ServerLevel serverWorld = (ServerLevel) player.level();
            if (serverWorld != null) {
                serverWorld = serverWorld.getServer().getLevel(registryKey);

                Vector3i targetPos = getSpawnCoordinate();
                if(registryKey != WORLD_KEY) targetPos = new Vector3i(serverWorld.getSharedSpawnPos().getX(), 80, serverWorld.getSharedSpawnPos().getZ());

                player.stopSleeping();
                ((ServerPlayer) player).teleportTo(serverWorld, targetPos.x, targetPos.y + 10, targetPos.z, 0, 0);
                Level targetWorld =  player.level();
                int highY = 1 + getHighestYAtXZ(targetPos.x, targetPos.z);

                player.moveTo(targetPos.x, highY, targetPos.z);
            }
        }
    }

    public static int getHighestYAtXZ(int x, int z) {
        return (int) EdumiaHeightMap.getHeight(x, z);
    }

    public static Vector3i getSpawnCoordinate(){
        double worldIteration = Math.pow(2, Edumia.MAP_ITERATION);
        int x = (int)((ME_SPAWN_LOCATION.x * worldIteration));
        int z = (int)((ME_SPAWN_LOCATION.z * worldIteration));

        return new Vector3i(x, ME_SPAWN_LOCATION.y, z);
    }
}
