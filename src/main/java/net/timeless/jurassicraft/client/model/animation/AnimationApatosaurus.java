package net.timeless.jurassicraft.client.model.animation;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.timeless.animationapi.client.Animator;
import net.timeless.jurassicraft.client.model.ModelDinosaur;
import net.timeless.jurassicraft.common.entity.EntityApatosaurus;
import net.timeless.unilib.client.model.json.IModelAnimator;
import net.timeless.unilib.client.model.json.ModelJson;
import net.timeless.unilib.client.model.tools.MowzieModelRenderer;

@SideOnly(Side.CLIENT)
public class AnimationApatosaurus implements IModelAnimator
{
    @Override
    public void setRotationAngles(ModelJson modelJson, float f, float f1, float rotation, float rotationYaw, float rotationPitch, float partialTicks, Entity entity)
    {
        ModelDinosaur model = (ModelDinosaur) modelJson;
        Animator animator = model.animator;

        MowzieModelRenderer head = model.getCube("head");

        MowzieModelRenderer neck1 = model.getCube("neck1");
        MowzieModelRenderer neck2 = model.getCube("neck2");
        MowzieModelRenderer neck3 = model.getCube("neck3");
        MowzieModelRenderer neck4 = model.getCube("neck4");
        MowzieModelRenderer neck5 = model.getCube("neck5");
        MowzieModelRenderer neck6 = model.getCube("neck6");

        MowzieModelRenderer body_1 = model.getCube("hips");
        MowzieModelRenderer tail1 = model.getCube("tail1");
        MowzieModelRenderer tail2 = model.getCube("tail2");
        MowzieModelRenderer tail3 = model.getCube("tail3");
        MowzieModelRenderer tail4 = model.getCube("tail4");
        MowzieModelRenderer tail5 = model.getCube("tail5");

        MowzieModelRenderer top_leg_left = model.getCube("top leg left");
        MowzieModelRenderer top_leg_right = model.getCube("top leg right");

        MowzieModelRenderer bottom_leg_left = model.getCube("bottom front left leg");
        MowzieModelRenderer bottom_leg_right = model.getCube("bottom front right leg");

        MowzieModelRenderer left_back_foot = model.getCube("left back foot");
        MowzieModelRenderer right_back_foot = model.getCube("right back foot");

        MowzieModelRenderer front_right_top_leg = model.getCube("front right top leg");
        MowzieModelRenderer front_left_top_leg = model.getCube("front left top leg");

        MowzieModelRenderer bottom_front_right_leg = model.getCube("bottom front right leg");
        MowzieModelRenderer bottom_front_left_leg = model.getCube("bottom front left leg");

        MowzieModelRenderer front_right_foot = model.getCube("front right foot");
        MowzieModelRenderer front_left_foot = model.getCube("front left foot");

        MowzieModelRenderer[] neckParts = new MowzieModelRenderer[]{head, neck6, neck5, neck4, neck3, neck2, neck1};
        MowzieModelRenderer[] tailParts = new MowzieModelRenderer[]{tail5, tail4, tail3};
        MowzieModelRenderer[] tailParts2 = new MowzieModelRenderer[]{tail5, tail4, tail3, tail2, tail1};

        float scaleFactor = 0.2F;
        float height = 0.85F;
        float frontOffset = -2F;
        float animationDegree = 0.25F;

        model.bob(body_1, 2 * scaleFactor, height * animationDegree, false, f, f1);
        model.bob(top_leg_left, 2 * scaleFactor, height * animationDegree, false, f, f1);
        model.bob(top_leg_right, 2 * scaleFactor, height * animationDegree, false, f, f1);
        model.walk(body_1, 2 * scaleFactor, 0.15F * height * animationDegree, true, -1.5F, 0F, f, f1);
        model.chainWave(tailParts2, 2 * scaleFactor, 0.08F * animationDegree, 2, f, f1);
        model.chainWave(neckParts, 2 * scaleFactor, 0.3F * animationDegree, 4, f, f1);
        tail1.rotateAngleX += 0.1 * f1;

        model.walk(top_leg_left, 1F * scaleFactor, 1F * animationDegree, false, 0F, 0F, f, f1);
        model.walk(bottom_leg_left, 1F * scaleFactor, 1F * animationDegree, true, 1F, 0F, f, f1);
        model.walk(left_back_foot, 1F * scaleFactor, 1F * animationDegree, false, 1.5F, 0F, f, f1);

        model.walk(top_leg_right, 1F * scaleFactor, 1F * animationDegree, true, 0F, 0F, f, f1);
        model.walk(bottom_leg_right, 1F * scaleFactor, 1F * animationDegree, false, 1F, 0F, f, f1);
        model.walk(right_back_foot, 1F * scaleFactor, 1F * animationDegree, true, 1.5F, 0F, f, f1);

        model.walk(front_right_top_leg, 1F * scaleFactor, 2F * animationDegree, true, frontOffset + 0F, -0.1F, f, f1);
        model.walk(bottom_front_right_leg, 1F * scaleFactor, 1.5F * animationDegree, true, frontOffset + 2F, -0.2F, f, f1);
        model.walk(front_right_foot, 1F * scaleFactor, 1.3F * animationDegree, false, frontOffset + 1.5F, 0F, f, f1);

        model.walk(front_left_top_leg, 1F * scaleFactor, 2F * animationDegree, false, frontOffset + 0F, -0.1F, f, f1);
        model.walk(bottom_front_left_leg, 1F * scaleFactor, 1.5F * animationDegree, false, frontOffset + 2F, -0.2F, f, f1);
        model.walk(front_left_foot, 1F * scaleFactor, 1.3F * animationDegree, true, frontOffset + 1.5F, 0F, f, f1);

        // Idle
        model.walk(body_1, 0.05F, 0.025F, false, 0, 0, entity.ticksExisted, 1);
        model.walk(front_right_top_leg, 0.05F, 0.1F, false, 0, 0, entity.ticksExisted, 1);
        model.walk(front_left_top_leg, 0.05F, 0.1F, false, 0, 0, entity.ticksExisted, 1);
        model.walk(bottom_front_right_leg, 0.05F, 0.3F, true, 0, 0, entity.ticksExisted, 1);
        model.walk(bottom_front_left_leg, 0.05F, 0.3F, true, 0, 0, entity.ticksExisted, 1);
        model.walk(front_right_foot, 0.05F, 0.175F, false, 0, 0, entity.ticksExisted, 1);
        model.walk(front_left_foot, 0.05F, 0.175F, false, 0, 0, entity.ticksExisted, 1);
        model.chainWave(neckParts, 0.05F, -0.05F, -4, entity.ticksExisted, 1);
        model.chainWave(tailParts, 0.05F, -0.05F, 1, entity.ticksExisted, 1);
        model.chainSwing(tailParts, 0.05F, 0.2F, 2, entity.ticksExisted, 1);

        ((EntityApatosaurus) entity).tailBuffer.applyChainSwingBuffer(tailParts2);
    }
}