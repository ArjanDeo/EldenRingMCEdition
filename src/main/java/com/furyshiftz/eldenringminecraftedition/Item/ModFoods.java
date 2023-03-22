package com.furyshiftz.eldenringminecraftedition.Item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BOILED_PRAWN = (new FoodProperties.Builder()).fast().nutrition(5).saturationMod(0.6F).build();
    public static final FoodProperties PRAWN = (new FoodProperties.Builder()).fast().nutrition(2).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.POISON, 100, 0), 0.6F).build();

}
