package com.legends.edumia.client.models.renderer;

import com.legends.edumia.Edumia;
import com.legends.edumia.client.models.entity.ModelRhino;
import com.legends.edumia.entity.animals.EntityRhino;
import com.legends.edumia.entity.layers.ModModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RendererRhino extends MobRenderer<EntityRhino, ModelRhino<EntityRhino>> {
    private static final ResourceLocation RHINO_LOCATION = new ResourceLocation(Edumia.MODID,
            "textures/entity/rhino.png");

    public RendererRhino(EntityRendererProvider.Context pContext) {
        super(pContext, new ModelRhino<>(pContext.bakeLayer(ModModelLayers.RHINO_LAYER)), 2f);
    }


    @Override
    public ResourceLocation getTextureLocation(EntityRhino pEntity) {
        return RHINO_LOCATION;
    }

    @Override
    public void render(EntityRhino pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
