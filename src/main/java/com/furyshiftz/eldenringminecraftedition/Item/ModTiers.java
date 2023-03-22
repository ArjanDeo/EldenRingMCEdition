package com.furyshiftz.eldenringminecraftedition.Item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier MYTHRITE = new ForgeTier(3, 1000,2.7f, 3.2f, 22,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.MYTHRITE_INGOT.get()));
}