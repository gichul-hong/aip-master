package com.sec.aip.aipmaster.config;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sec.aip.aipmaster.common.properties.KeycloakJsonProperties;

@Configuration
public class KeycloakConfig {

    @Autowired
    private KeycloakJsonProperties properties;
    
	@Bean
	public Keycloak aipKeycloakClient() {
		
//		Keycloak keycloakClient = KeycloakBuilder.builder()
//				.serverUrl(properties.getAuthServerUrl())
//				.grantType(OAuth2Constants.PASSWORD)
//				.realm(properties.getRealm())
//				.clientId(properties.getResource())
//				.clientSecret(properties.getSecret())
//				.username("aip-admin")
//				.password("1234")
//				.resteasyClient(
//						new ResteasyClientBuilder()
//						.connectionPoolSize(10).build()
//						).build();
		
		Keycloak keycloakClient = KeycloakBuilder.builder()
				.serverUrl("http://localhost:8080//auth")
				.grantType(OAuth2Constants.PASSWORD)
				.realm("aip")
				.clientId("aip-master")
				.clientSecret("bf56a959-5d5e-457d-a781-8ffcd6cd159e")
				.username("aip-admin")
				.password("1234")
				.resteasyClient(
						new ResteasyClientBuilder()
						.connectionPoolSize(10).build()
						).build();


		return keycloakClient;
	}
	
	@Bean
	public RealmResource aipRealm(Keycloak aipKeycloakClient) {
		
		return aipKeycloakClient.realm("aip");
	}
}
