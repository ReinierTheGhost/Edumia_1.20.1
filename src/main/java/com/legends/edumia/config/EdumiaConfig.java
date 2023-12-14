package com.legends.edumia.config;


import com.legends.edumia.Edumia;
import com.legends.edumia.core.block.builder.Props;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class EdumiaConfig {
    public static final ClientConfig CLIENT;
    private static final ForgeConfigSpec CLIENT_SPEC;
   // private static final ForgeConfigSpec COMMON_SPEC;
   // private static final ForgeConfigSpec SERVER_SPEC;


    public static int defaultBigBookTextScale = 0;
    public EdumiaConfig(){

    }

    public static void register(IEventBus eventBus) {
        eventBus.register(EdumiaConfig.class);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_SPEC);
        // ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_SPEC);
        //ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_SPEC);
    }

    @SubscribeEvent
    public static void onModConfig(ModConfigEvent event){
        IConfigSpec spec = event.getConfig().getSpec();
        if (spec == CLIENT_SPEC){
            CLIENT.bakeFields();
        }

    }
    private static final BoolHolder makeBool(List<ConfigValueHolder<?>> collection, ForgeConfigSpec.Builder builder, String key, boolean def, String commemt){
        return makeBool(collection, builder, key, def, false, commemt);
    }

    private static final BoolHolder makeBool(List<ConfigValueHolder<?>> collection, ForgeConfigSpec.Builder builder, String key, boolean def, boolean worldRestart, String commemt){
        builder.comment(commemt).translation(String.format("config.%s.%s", Edumia.MODID, key));
        if (worldRestart){
            builder.worldRestart();
        }

        ForgeConfigSpec.BooleanValue boolVal = builder.define(key, def);
        BoolHolder holder = new BoolHolder(boolVal);
        collection.add(holder);
        return holder;
    }



    static {
        Pair<ClientConfig, ForgeConfigSpec> clientPair = (new ForgeConfigSpec.Builder()).configure(ClientConfig::new);
        CLIENT = (ClientConfig) clientPair.getLeft();
        CLIENT_SPEC = (ForgeConfigSpec) clientPair.getRight();
       // COMMON = (CommonConfig)
    }

    public static class BoolHolder extends ConfigValueHolder<Boolean>{
        public BoolHolder(ForgeConfigSpec.ConfigValue<Boolean> cfgVal){
            super(cfgVal);
        }

        public void toggleAndSave(){
            this.setAndSave(!(Boolean)this.get());
        }
    }
    public abstract static class ConfigValueHolder<T>{
        public final ForgeConfigSpec.ConfigValue<T> configValue;
        private T value;
        public ConfigValueHolder(ForgeConfigSpec.ConfigValue<T> cfgVal){
            this.configValue = cfgVal;
        }

        public void bake(){
            this.value = this.configValue.get();
        }

        public T get(){
            return this.value;
        }

        public void setAndSave(T newValue){
            this.configValue.set(this.value = newValue);
            this.configValue.save();
        }

    }

    public static class ClientConfig{
        private final List<ConfigValueHolder<?>> clientFields = new ArrayList();

        //public final BoolHolder biomeMap;
        public final BoolHolder modMainMenu;

        public ClientConfig(ForgeConfigSpec.Builder builder){
            builder.push("gui");
            this.modMainMenu = EdumiaConfig.makeBool(this.clientFields, builder, "modMainMenu",true, "Display the mod's custom main menu screen");
           // this.biomeMap = EdumiaConfig.makeBool(this.clientFields, builder, "biomeMap", false, "");
            builder.pop();
        }

        public void bakeFields() {
            this.clientFields.forEach(ConfigValueHolder::bake);
        }
    }

    public static class CommonConfig{

    }


}
