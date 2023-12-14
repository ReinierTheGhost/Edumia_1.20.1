package com.legends.edumia.init;

import com.legends.edumia.config.ClientsideCurrentServerConfigSettings;

public class EdumiaWorldTypes {

    public static boolean hasMapFeaturesClientside(){
        return ClientsideCurrentServerConfigSettings.INSTANCE.hasMapFeatures;
    }
}
