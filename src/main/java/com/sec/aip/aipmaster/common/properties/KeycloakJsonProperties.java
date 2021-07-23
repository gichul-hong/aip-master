package com.sec.aip.aipmaster.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Component
@PropertySource(value = "classpath:keycloak.json")
@ConfigurationProperties
@Getter
@Setter
public class KeycloakJsonProperties {
    
    @JsonProperty("auth-server-url")
    private String authServerUrl;
    
    @JsonProperty("realm")
    private String realm;
    
    @JsonProperty("resource")
    private String resource;
    
    @JsonProperty("secret")
    private String secret;
    
}
