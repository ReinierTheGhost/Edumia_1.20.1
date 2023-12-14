package com.legends.edumia.client.models.renderer;

import com.legends.edumia.Edumia;
import com.legends.edumia.client.models.entity.ModelAlligator;
import com.legends.edumia.entity.animals.EntityAlligator;
import com.legends.edumia.entity.layers.ModModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RendererAligator extends MobRenderer<EntityAlligator, ModelAlligator<EntityAlligator>> {
    private static final ResourceLocation ALLIGATOR_LOCATION = new ResourceLocation(Edumia.MODID,
            "textures/entity/alligator_american.png");

    public RendererAligator(EntityRendererProvider.Context pContext) {
        super(pContext, new ModelAlligator<>(pContext.bakeLayer(ModModelLayers.ALLIGATOR_LAYER)), 2f);
    }


    @Override
    public ResourceLocation getTextureLocation(EntityAlligator pEntity) {
        return ALLIGATOR_LOCATION;
    }

    @Override
    public void render(EntityAlligator pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
