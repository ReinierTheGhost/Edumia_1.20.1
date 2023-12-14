package com.legends.edumia.client.models.entity.bosses;
// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ModelSamuraiBoss<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "modelsamuraiboss"), "main");
	private final ModelPart body;

	public ModelSamuraiBoss(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(48, 0).addBox(-6.0F, 0.0F, -3.0F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(0.5F, 0.0F, 3.0F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(119, 88).addBox(-5.5F, 0.0F, 3.0F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(97, 65).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(76, 49).addBox(-4.0F, 6.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(64, 12).addBox(-4.75F, 10.75F, -4.0F, 9.5F, 3.0F, 7.5F, new CubeDeformation(0.0F))
		.texOffs(82, 33).addBox(-2.0F, 10.25F, -5.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 120).addBox(-2.5F, 6.0F, -3.5F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 2.5F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(60, 106).addBox(0.0F, -5.0F, 0.0F, 2.0F, 5.0F, 5.8F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0866F, 10.6194F, -2.9F, 0.0F, 0.0F, -0.3927F));

		PartDefinition body_r2 = body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(109, 91).addBox(-2.0F, -5.0F, 0.0F, 2.0F, 5.0F, 5.8F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0866F, 10.6194F, -2.9F, 0.0F, 0.0F, 0.3927F));

		PartDefinition body_r3 = body.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(98, 28).addBox(-10.0F, -3.0F, 0.0F, 10.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 6.4672F, -3.3827F, 0.3927F, 0.0F, 0.0F));

		PartDefinition body_r4 = body.addOrReplaceChild("body_r4", CubeListBuilder.create().texOffs(64, 23).addBox(-11.0F, -4.0F, 0.0F, 11.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 3.6955F, -4.5307F, -0.3927F, 0.0F, 0.0F));

		PartDefinition body_r5 = body.addOrReplaceChild("body_r5", CubeListBuilder.create().texOffs(92, 12).addBox(0.0F, -2.0F, 0.0F, 5.0F, 2.0F, 5.8F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2346F, 2.3478F, -2.9F, 0.0F, 0.0F, -0.3927F));

		PartDefinition body_r6 = body.addOrReplaceChild("body_r6", CubeListBuilder.create().texOffs(94, 20).addBox(-5.0F, -2.0F, 0.0F, 5.0F, 2.0F, 5.8F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2346F, 2.3478F, -2.9F, 0.0F, 0.0F, 0.3927F));

		PartDefinition arm_right = body.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(8, 98).addBox(-4.0F, -2.0F, -2.5F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(20, 104).addBox(-3.8F, 2.0F, -2.75F, 4.5F, 2.0F, 5.5F, new CubeDeformation(0.0F))
		.texOffs(70, 103).addBox(-3.9F, -1.0F, -2.75F, 4.5F, 2.0F, 5.5F, new CubeDeformation(0.0F))
		.texOffs(16, 112).addBox(-4.0F, 5.0F, -2.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 2.0F, 0.0F));

		PartDefinition arm_r1 = arm_right.addOrReplaceChild("arm_r1", CubeListBuilder.create().texOffs(118, 33).addBox(-3.9F, 7.0F, -2.5F, 3.8F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.2758F, 5.6407F, -0.3927F, 0.0F, 0.0F));

		PartDefinition arm_r2 = arm_right.addOrReplaceChild("arm_r2", CubeListBuilder.create().texOffs(77, 72).addBox(-5.75F, -5.0F, -0.25F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition armor_right = arm_right.addOrReplaceChild("armor_right", CubeListBuilder.create(), PartPose.offset(-4.5F, 4.5F, 0.0F));

		PartDefinition arm_r3 = armor_right.addOrReplaceChild("arm_r3", CubeListBuilder.create().texOffs(117, 50).addBox(-2.75F, -1.0F, -0.25F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition hand_right = arm_right.addOrReplaceChild("hand_right", CubeListBuilder.create().texOffs(99, 84).addBox(-1.8F, -0.0778F, -0.9523F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 91).addBox(-2.8F, -0.0778F, -1.4523F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(117, 115).addBox(0.45F, 4.4222F, -1.2023F, 2.0F, 2.0F, 4.5F, new CubeDeformation(0.0F))
		.texOffs(117, 71).addBox(0.45F, 1.4222F, -1.2023F, 2.0F, 2.0F, 4.5F, new CubeDeformation(0.0F)), PartPose.offset(-2.2F, 10.0778F, -1.5477F));

		PartDefinition arm_r4 = hand_right.addOrReplaceChild("arm_r4", CubeListBuilder.create().texOffs(32, 114).addBox(-3.7F, 2.0F, 11.5F, 3.8F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -8.75F, -9.5F, -0.3927F, 0.0F, 0.0F));

		PartDefinition arm_r5 = hand_right.addOrReplaceChild("arm_r5", CubeListBuilder.create().texOffs(108, 105).addBox(-4.5F, 12.5F, -2.5F, 4.5F, 4.5F, 4.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, -4.8278F, 1.2977F, 0.0F, 0.0F, -0.3927F));

		PartDefinition sword = hand_right.addOrReplaceChild("sword", CubeListBuilder.create().texOffs(48, 114).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 64).addBox(-0.5F, -38.0F, -1.0F, 1.0F, 33.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 60).addBox(0.0F, -47.0F, -2.5F, 0.0F, 42.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(64, 49).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(114, 40).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(78, 0).addBox(-1.5F, 10.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, 9.9222F, 1.0477F, 1.5708F, 0.0F, 0.0F));

		PartDefinition arm_left = body.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(58, 94).addBox(0.0F, -2.0F, -2.5F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(101, 74).addBox(-0.7F, 2.0F, -2.75F, 4.5F, 2.0F, 5.5F, new CubeDeformation(0.0F))
		.texOffs(101, 0).addBox(-0.6F, -1.0F, -2.75F, 4.5F, 2.0F, 5.5F, new CubeDeformation(0.0F))
		.texOffs(111, 62).addBox(0.0F, 5.0F, -2.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 2.0F, 0.0F));

		PartDefinition arm_r6 = arm_left.addOrReplaceChild("arm_r6", CubeListBuilder.create().texOffs(71, 94).addBox(0.1F, 7.0F, -2.5F, 3.8F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.2758F, 5.6407F, -0.3927F, 0.0F, 0.0F));

		PartDefinition arm_r7 = arm_left.addOrReplaceChild("arm_r7", CubeListBuilder.create().texOffs(48, 12).addBox(-0.25F, 3.0F, -0.25F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(59, 78).addBox(-0.25F, 3.0F, -5.85F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -7.5F, 2.1F, 0.0F, 0.0F, -0.3927F));

		PartDefinition arm_r8 = arm_left.addOrReplaceChild("arm_r8", CubeListBuilder.create().texOffs(64, 12).addBox(4.25F, -1.0F, -0.25F, 1.5F, 6.0F, 1.5F, new CubeDeformation(0.0F))
		.texOffs(74, 121).addBox(4.25F, -1.0F, -5.85F, 1.5F, 6.0F, 1.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3268F, -11.9009F, 2.35F, 0.0F, 0.0F, 0.3927F));

		PartDefinition arm_r9 = arm_left.addOrReplaceChild("arm_r9", CubeListBuilder.create().texOffs(123, 78).addBox(3.75F, 3.0F, -0.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, -3.5F, 2.85F, 0.0F, 0.7854F, 0.0F));

		PartDefinition arm_r10 = arm_left.addOrReplaceChild("arm_r10", CubeListBuilder.create().texOffs(56, 117).addBox(2.5F, 0.0F, -0.25F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -6.5F, 2.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition arm_r11 = arm_left.addOrReplaceChild("arm_r11", CubeListBuilder.create().texOffs(64, 33).addBox(-0.25F, -5.0F, -0.25F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition armor_left = arm_left.addOrReplaceChild("armor_left", CubeListBuilder.create(), PartPose.offset(4.5F, 4.5F, 0.0F));

		PartDefinition arm_r12 = armor_left.addOrReplaceChild("arm_r12", CubeListBuilder.create().texOffs(105, 115).addBox(-0.25F, 0.0F, -0.25F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition hand_left = arm_left.addOrReplaceChild("hand_left", CubeListBuilder.create().texOffs(40, 64).addBox(-2.2F, -0.0778F, -0.9523F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(83, 61).addBox(-2.7F, 1.9222F, -1.7023F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.2F, 10.0778F, -1.5477F));

		PartDefinition arm_r13 = hand_left.addOrReplaceChild("arm_r13", CubeListBuilder.create().texOffs(108, 8).addBox(0.0F, 12.5F, -2.5F, 4.5F, 4.5F, 4.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8F, -4.8278F, 1.2977F, 0.0F, 0.0F, 0.3927F));

		PartDefinition arm_r14 = hand_left.addOrReplaceChild("arm_r14", CubeListBuilder.create().texOffs(72, 113).addBox(-0.1F, 2.0F, 11.5F, 3.8F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -8.75F, -9.5F, -0.3927F, 0.0F, 0.0F));

		PartDefinition leg_right = body.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(8, 64).addBox(-3.75F, -1.0F, -3.75F, 6.0F, 14.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(98, 55).addBox(-2.5F, 13.0F, -3.25F, 4.5F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 14.0F, 0.0F));

		PartDefinition foot_right = leg_right.addOrReplaceChild("foot_right", CubeListBuilder.create().texOffs(89, 110).addBox(-4.5F, 1.0F, -0.5F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(83, 88).addBox(-4.0F, -2.0F, 0.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(74, 88).addBox(-4.0F, 12.0F, -4.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 62).addBox(-4.0F, 12.0F, 1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(84, 0).addBox(-4.0F, 9.0F, -5.0F, 4.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, 13.0F, -2.25F));

		PartDefinition leg_r1 = foot_right.addOrReplaceChild("leg_r1", CubeListBuilder.create().texOffs(110, 18).addBox(-3.8F, -2.0F, 0.0F, 3.8F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 10.8716F, -2.3519F, 0.3927F, 0.0F, 0.0F));

		PartDefinition leg_left = body.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(57, 57).addBox(-2.25F, -1.0F, -3.75F, 6.0F, 14.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(98, 46).addBox(-2.0F, 13.0F, -3.25F, 4.5F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 14.0F, 0.0F));

		PartDefinition foot_left = leg_left.addOrReplaceChild("foot_left", CubeListBuilder.create().texOffs(0, 110).addBox(-0.5F, 1.0F, -0.5F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -2.0F, 0.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(88, 46).addBox(0.0F, 12.0F, -4.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(76, 61).addBox(0.0F, 12.0F, 1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(57, 82).addBox(0.0F, 9.0F, -5.0F, 4.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.75F, 13.0F, -2.25F));

		PartDefinition leg_r2 = foot_left.addOrReplaceChild("leg_r2", CubeListBuilder.create().texOffs(105, 33).addBox(0.0F, -2.0F, 0.0F, 3.8F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 10.8716F, -2.3519F, 0.3927F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(111, 82).addBox(-3.0F, -7.0F, -4.5F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(117, 0).addBox(-3.0F, -6.5F, -2.5F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(95, 99).addBox(-2.5F, -8.0F, -2.5F, 5.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(113, 102).addBox(-1.5F, -3.0F, -4.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 55).addBox(-1.5F, -2.0F, -4.25F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(48, 0).addBox(-3.5F, -17.0F, 0.75F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(120, 25).addBox(-5.0F, -21.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 10.5537F, -11.771F, -0.3927F, 0.0F, 0.0F));

		PartDefinition head_r2 = head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(21, 98).addBox(-5.5F, -19.0F, 0.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 10.5537F, -12.271F, -0.3927F, 0.0F, 0.0F));

		PartDefinition head_r3 = head.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(42, 104).addBox(-5.3F, -24.0F, 0.0F, 4.6F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 18.7975F, 9.7389F, 0.3927F, 0.0F, 0.0F));

		PartDefinition head_r4 = head.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(88, 33).addBox(-5.4F, -19.0F, -8.75F, 4.8F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 12.0F, -4.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition head_r5 = head.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(8, 85).addBox(-5.75F, -21.5F, -3.5F, 5.5F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 12.0F, -4.5F, -0.3927F, 0.0F, 0.0F));

		PartDefinition head_r6 = head.addOrReplaceChild("head_r6", CubeListBuilder.create().texOffs(40, 78).addBox(-5.9F, -18.0F, 9.0F, 5.8F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 12.0F, -4.5F, 0.3927F, 0.0F, 0.0F));

		PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5901F, -1.5565F));

		PartDefinition mouth_r1 = mouth.addOrReplaceChild("mouth_r1", CubeListBuilder.create().texOffs(95, 74).addBox(-5.5F, -3.0F, 15.25F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 14.0F, -10.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition mouth_r2 = mouth.addOrReplaceChild("mouth_r2", CubeListBuilder.create().texOffs(84, 6).addBox(-5.0F, -7.0F, 11.25F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(27, 64).addBox(-5.5F, -9.0F, 11.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 104).addBox(-5.5F, -8.0F, 11.25F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 13.3401F, -10.1935F, 0.3927F, 0.0F, 0.0F));

		PartDefinition tooth_right = head.addOrReplaceChild("tooth_right", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -2.9967F, -3.624F, 0.0873F, 0.5236F, 0.0F));

		PartDefinition tooth_r1 = tooth_right.addOrReplaceChild("tooth_r1", CubeListBuilder.create().texOffs(122, 29).addBox(-5.99F, -14.0F, 8.75F, 1.01F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -22.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition tooth_r2 = tooth_right.addOrReplaceChild("tooth_r2", CubeListBuilder.create().texOffs(123, 59).addBox(-5.99F, -14.5F, 8.75F, 1.01F, 1.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 9.7781F, -17.5579F, -0.3927F, 0.0F, 0.0F));

		PartDefinition tooth_r3 = tooth_right.addOrReplaceChild("tooth_r3", CubeListBuilder.create().texOffs(114, 122).addBox(-6.0F, -15.0F, 8.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 17.6231F, -4.8365F, 0.3927F, 0.0F, 0.0F));

		PartDefinition tooth_right2 = head.addOrReplaceChild("tooth_right2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -2.2467F, -2.624F, 0.6981F, 0.3927F, 0.0F));

		PartDefinition tooth_r4 = tooth_right2.addOrReplaceChild("tooth_r4", CubeListBuilder.create().texOffs(28, 112).addBox(-5.99F, -14.0F, 8.75F, 1.01F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -22.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition tooth_r5 = tooth_right2.addOrReplaceChild("tooth_r5", CubeListBuilder.create().texOffs(123, 5).addBox(-5.99F, -14.5F, 8.75F, 1.01F, 1.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 9.7781F, -17.5579F, -0.3927F, 0.0F, 0.0F));

		PartDefinition tooth_r6 = tooth_right2.addOrReplaceChild("tooth_r6", CubeListBuilder.create().texOffs(86, 103).addBox(-6.0F, -15.0F, 8.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 17.6231F, -4.8365F, 0.3927F, 0.0F, 0.0F));

		PartDefinition tooth_left3 = head.addOrReplaceChild("tooth_left3", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -2.2467F, -2.624F, 0.6981F, -0.3927F, 0.0F));

		PartDefinition tooth_r7 = tooth_left3.addOrReplaceChild("tooth_r7", CubeListBuilder.create().texOffs(0, 106).addBox(4.98F, -14.0F, 8.75F, 1.01F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, -22.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition tooth_r8 = tooth_left3.addOrReplaceChild("tooth_r8", CubeListBuilder.create().texOffs(122, 122).addBox(4.98F, -14.5F, 8.75F, 1.01F, 1.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 9.7781F, -17.5579F, -0.3927F, 0.0F, 0.0F));

		PartDefinition tooth_r9 = tooth_left3.addOrReplaceChild("tooth_r9", CubeListBuilder.create().texOffs(32, 99).addBox(5.0F, -15.0F, 8.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 17.6231F, -4.8365F, 0.3927F, 0.0F, 0.0F));

		PartDefinition horn_right = head.addOrReplaceChild("horn_right", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -6.9967F, -3.624F, -0.4363F, 0.2618F, 0.0F));

		PartDefinition horn_r1 = horn_right.addOrReplaceChild("horn_r1", CubeListBuilder.create().texOffs(64, 121).addBox(-5.99F, -14.0F, 6.75F, 1.01F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 1.0038F, -21.9128F, -0.7854F, 0.0F, 0.0F));

		PartDefinition horn_r2 = horn_right.addOrReplaceChild("horn_r2", CubeListBuilder.create().texOffs(12, 121).addBox(-5.99F, -14.5F, 7.75F, 1.01F, 1.5F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 8.7819F, -17.4708F, -0.3927F, 0.0F, 0.0F));

		PartDefinition horn_r3 = horn_right.addOrReplaceChild("horn_r3", CubeListBuilder.create().texOffs(40, 122).addBox(-6.0F, -15.0F, 8.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 16.6269F, -4.7494F, 0.3927F, 0.0F, 0.0F));

		PartDefinition horn_left = head.addOrReplaceChild("horn_left", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -6.9967F, -3.624F, -0.4363F, -0.2618F, 0.0F));

		PartDefinition horn_r4 = horn_left.addOrReplaceChild("horn_r4", CubeListBuilder.create().texOffs(22, 121).addBox(4.98F, -14.0F, 6.75F, 1.01F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 1.0038F, -21.9128F, -0.7854F, 0.0F, 0.0F));

		PartDefinition horn_r5 = horn_left.addOrReplaceChild("horn_r5", CubeListBuilder.create().texOffs(99, 120).addBox(4.98F, -14.5F, 7.75F, 1.01F, 1.5F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 8.7819F, -17.4708F, -0.3927F, 0.0F, 0.0F));

		PartDefinition horn_r6 = horn_left.addOrReplaceChild("horn_r6", CubeListBuilder.create().texOffs(32, 122).addBox(5.0F, -15.0F, 8.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 16.6269F, -4.7494F, 0.3927F, 0.0F, 0.0F));

		PartDefinition tooth_left = head.addOrReplaceChild("tooth_left", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -2.9967F, -3.624F, 0.0873F, -0.5236F, 0.0F));

		PartDefinition tooth_r10 = tooth_left.addOrReplaceChild("tooth_r10", CubeListBuilder.create().texOffs(18, 121).addBox(4.98F, -14.0F, 8.75F, 1.01F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, -22.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition tooth_r11 = tooth_left.addOrReplaceChild("tooth_r11", CubeListBuilder.create().texOffs(123, 18).addBox(4.98F, -14.5F, 8.75F, 1.01F, 1.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 9.7781F, -17.5579F, -0.3927F, 0.0F, 0.0F));

		PartDefinition tooth_r12 = tooth_left.addOrReplaceChild("tooth_r12", CubeListBuilder.create().texOffs(122, 99).addBox(5.0F, -15.0F, 8.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 17.6231F, -4.8365F, 0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}