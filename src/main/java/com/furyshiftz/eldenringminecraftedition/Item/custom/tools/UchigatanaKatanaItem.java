package com.furyshiftz.eldenringminecraftedition.Item.custom.tools;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UchigatanaKatanaItem extends SwordItem {
    public UchigatanaKatanaItem(Tier pTier, int pInt, float pFloat, Properties pProperties) {
        super(pTier, pInt, pFloat, pProperties);
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.ermc.uchigatana_katana.tooltip.shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.ermc.uchigatana_katana.tooltip"));
        }
    }
}
