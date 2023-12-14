package com.legends.edumia.client.models.renderer;

import com.legends.edumia.Edumia;
import com.legends.edumia.client.models.entity.ModelBoar;
import com.legends.edumia.entity.animals.EntityBoar;
import com.legends.edumia.entity.layers.ModModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RendererBoar extends MobRenderer<EntityBoar, ModelBoar<EntityBoar>> {
    private static final ResourceLocation BOAR_LOCATION = new ResourceLocation(Edumia.MODID,
            "textures/entity/boar_light_brown.png");

    public RendererBoar(EntityRendererProvider.Context pContext) {
        super(pContext, new ModelBoar<>(pContext.bakeLayer(ModModelLayers.BOAR_LAYER)), 2f);
    }


    @Override
    public ResourceLocation getTextureLocation(EntityBoar pEntity) {
        return BOAR_LOCATION;
    }

    @Override
    public void render(EntityBoar pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
