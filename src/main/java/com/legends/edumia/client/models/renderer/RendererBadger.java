package com.legends.edumia.client.models.renderer;

import com.legends.edumia.Edumia;
import com.legends.edumia.client.models.entity.ModelBadger;
import com.legends.edumia.entity.animals.EntityBadger;
import com.legends.edumia.entity.layers.ModModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RendererBadger extends MobRenderer<EntityBadger, ModelBadger<EntityBadger>> {
    private static final ResourceLocation BADGER_LOCATION = new ResourceLocation(Edumia.MODID,
            "textures/entity/badger_european.png");

    public RendererBadger(EntityRendererProvider.Context pContext) {
        super(pContext, new ModelBadger<>(pContext.bakeLayer(ModModelLayers.BADGER_LAYER)), 2f);
    }


    @Override
    public ResourceLocation getTextureLocation(EntityBadger pEntity) {
        return BADGER_LOCATION;
    }

    @Override
    public void render(EntityBadger pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
