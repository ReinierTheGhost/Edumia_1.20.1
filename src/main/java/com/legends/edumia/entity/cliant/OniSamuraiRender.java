package com.legends.edumia.entity.cliant;

import com.legends.edumia.Edumia;
import com.legends.edumia.entity.bosses.OniSamuraiBoss;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class OniSamuraiRender{}/* extends GeoEntityRenderer<OniSamuraiBoss> {
    public OniSamuraiRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OniSamuraiModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(OniSamuraiBoss instance) {
        return new ResourceLocation(Edumia.MODID, "textures/entity/oni_samurai.png");
    }

    @Override
    public RenderType getRenderType(OniSamuraiBoss animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.0F, 1.0F, 1.0F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}*/
