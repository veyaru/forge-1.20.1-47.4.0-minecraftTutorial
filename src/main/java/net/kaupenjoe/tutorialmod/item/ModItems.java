//Tutorial2 make item package
//Tutorial2 make ModItems class.
//Tutorial2 goals is making mod items and put it in custom tab in creative mode.

package net.kaupenjoe.tutorialmod.item;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// Tutorial2 add line 15,16,17 (3 line bellow this). use tab to autocomplete and to add import above. add variable called ITEMS.
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    // Tutorial2 2 line bellow. add sapphire to the game.
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));

    // Tutorial2 add line 26,27 (2 line bellow this).
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
