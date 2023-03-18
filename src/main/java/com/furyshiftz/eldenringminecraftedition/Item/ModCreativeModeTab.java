package com.furyshiftz.eldenringminecraftedition.Item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ELDEN_RING_TAB = new CreativeModeTab("ermctab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MYTHRITE_INGOT.get());
        }
    };
}
