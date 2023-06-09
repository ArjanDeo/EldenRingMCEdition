package com.furyshiftz.eldenringminecraftedition.Item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ScepterAllKnowingItem extends Item {
    public ScepterAllKnowingItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if(isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;
                    break;
                }
            }

            if(!foundBlock) {
                player.sendMessage(new TranslatableComponent("item.ermc.scepter_of_the_all_knowing.no_valuables"),
                        player.getUUID());
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) {
        var ore_type = blockBelow.asItem().getRegistryName().toString();
        if (blockBelow.asItem().getRegistryName().toString().equals("minecraft:iron_ore")) {
             ore_type = "Iron Ore";
        } else if (blockBelow.asItem().getRegistryName().toString().equals("minecraft:coal_ore")) {
             ore_type = "Coal Ore";
        } else if (blockBelow.asItem().getRegistryName().toString().equals("minecraft:copper_ore")) {
             ore_type = "Copper Ore";
        } else if (blockBelow.asItem().getRegistryName().toString().equals("minecraft:diamond_ore")) {
             ore_type = "Diamond Ore";
        }
        player.sendMessage(new TextComponent("The scepter detects " + ore_type + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), player.getUUID());
    }

    private boolean isValuableBlock(Block block) {
        return block == Blocks.COAL_ORE || block == Blocks.COPPER_ORE
                || block == Blocks.DIAMOND_ORE || block == Blocks.IRON_ORE;
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
        {
            if (Screen.hasShiftDown()) {
                pTooltipComponents.add(new TranslatableComponent("tooltip.ermc.scepter_of_the_all_knowing.tooltip.shift"));
            } else {
                pTooltipComponents.add(new TranslatableComponent("tooltip.ermc.scepter_of_the_all_knowing.tooltip"));
            }
        }
}