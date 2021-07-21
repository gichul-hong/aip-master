package com.sec.aip.aipmaster.config;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

	@Bean
	public Keycloak keycloakClient(String realmName) {
		
	}
	Keycloak keycloak = KeycloakBuilder.builder()
		    .serverUrl("http://localhost:8080/auth")
		    .grantType(OAuth2Constants.PASSWORD)
		    .realm("realm-name")
		    .clientId("keycloak-admin")
		    .username("username")
		    .password("password")
		    .resteasyClient(
		        new ResteasyClientBuilder()
		            .connectionPoolSize(10).build()
		    ).build();

//		keycloak.tokenManager().getAccessToken();
		RealmResource realmResource = keycloak.realm("realm-name");
	
}
