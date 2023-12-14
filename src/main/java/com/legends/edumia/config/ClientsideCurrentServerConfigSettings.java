package com.legends.edumia.config;

public class ClientsideCurrentServerConfigSettings {
    public static final ClientsideCurrentServerConfigSettings INSTANCE = new ClientsideCurrentServerConfigSettings();
    public boolean areasOfInfluence;
    public boolean smallerBees;
    public boolean hasMapFeatures;
    public int forceFogOfUnknown;

    private ClientsideCurrentServerConfigSettings(){

    }
}
