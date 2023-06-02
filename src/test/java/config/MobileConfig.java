package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${env}.properties",
})

public interface MobileConfig extends Config {

    @Key("device")
    @DefaultValue("Samsung Galaxy S20")
    String getDevice();

    @Key("os_version")
    @DefaultValue("12.0")
    String getOsVersion();

    @Key("app_url")
    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String getApp();

}