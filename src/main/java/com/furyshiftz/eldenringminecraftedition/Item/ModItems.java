package com.furyshiftz.eldenringminecraftedition.Item;

import com.furyshiftz.eldenringminecraftedition.EldenRingMC;
import com.furyshiftz.eldenringminecraftedition.Item.custom.ScepterAllKnowingItem;
import com.furyshiftz.eldenringminecraftedition.sound.ModSounds;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EldenRingMC.MOD_ID);
    public static final RegistryObject<Item>  SPIRIT_CALLING_BELL = ITEMS.register("spirit_calling_bell", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ELDEN_RING_TAB).stacksTo(1)));

    public static final RegistryObject<Item>  MYTHRITE_INGOT = ITEMS.register("mythrite_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ELDEN_RING_TAB)));
    public static final RegistryObject<Item>  GOSKIN_APOSTLE_DISC = ITEMS.register("godskin_apostle_music_disc", () -> new RecordItem(4, ModSounds.GODSKIN_APOSTLE_THEME, new Item.Properties().tab(ModCreativeModeTab.ELDEN_RING_TAB).stacksTo(1)));
    public static final RegistryObject<Item>  SCEPTER_ALL_KNOWING = ITEMS.register("scepter_of_the_all_knowing", () -> new ScepterAllKnowingItem(new Item.Properties().tab(ModCreativeModeTab.ELDEN_RING_TAB).stacksTo(1)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
