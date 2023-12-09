package com.microservice.user.Config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Bean
    public Keycloak Keycloak(){
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:9090/")
                .realm("test")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId("admin-cli")
                .clientSecret("AkvZtJUDiJ3CA7iHdfcObsTeYpi4H7wX")
                .build();
    }
}
