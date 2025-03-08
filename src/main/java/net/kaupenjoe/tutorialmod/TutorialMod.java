//this will change folder structure in java folder. hover>more actions>move to package.
//Tutorial1 change the package name com.example.examplemod to net.kaupenjoe.tutorialmod.
package net.kaupenjoe.tutorialmod;

import com.mojang.logging.LogUtils;
import net.kaupenjoe.tutorialmod.item.ModCreativeModTabs;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
// Tutorial1: change the class name ExampleMod to TutorialMod.
// Tutorial1: use shift+f6 to replace text on all file.
public class TutorialMod
{
    // Define mod id in a common place for everything to reference. changed MODID TO MOD_ID AND STRING TO "tutorialmod". shift+f6 to use replace.
    // Tutorial1: change MOD.ID to MOD_ID, change "examplemod" to "tutorialmod".
    // Tutorial1: public static final why?
    public static final String MOD_ID = "tutorialmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TutorialMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Tutorial2 add 1 line bellow. register the ModCreativeModTabs to the modEventBus.
        ModCreativeModTabs.register(modEventBus);

        // Tutorial2 add 1 line bellow this. basically to make sure ModItems is properly registered.
        ModItems.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab

        // Tutorial2 1 line bellow. THIS IS SUPER IMPORTANT. without this addCreative will not work.
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab

    // Tutorial2 addCreative method is for adding mod item to vanilla minecraft tab.
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        // Tutorial2 add 3 line bellow. add mod item to INGREDIENTS tab in creative.
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SAPPHIRE);
            event.accept(ModItems.RAW_SAPPHIRE);

        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
