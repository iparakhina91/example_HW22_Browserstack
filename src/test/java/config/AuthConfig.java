package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {

    @Key("browserstack.user")
    String getUser();

    @Key("browserstack.key")
    String getPassword();

    @Key("remoteUrl")
    String getRemoteUrl();
}
