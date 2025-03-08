// Tutorial2 this class is for making custom tab in creative mode.

package net.kaupenjoe.tutorialmod.item;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {

    // Tutorial2 2 line bellow notice the DeferredRegister<CreativeModeTab>. thats for creating custom tab in creative mode.
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    // Tutorial2 add 3 line bellow. it is for naming custom tab and adding sapphire icon to it.
    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))

                    // Tutorial2 ItemDisplayParameters and Output is not the same as the tutorial, caution.
                    // Tutorial2 add 5 line bellow for adding 3 custom item to the custom tab.
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModItems.RAW_SAPPHIRE.get());

                        // Tutorial2 for adding vanilla item
                        output.accept(Items.DIAMOND);
                    })
                    .build());
    // Tutorial2 dont forget 2 line bellow.
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
