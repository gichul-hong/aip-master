package com.sec.aip.aipmaster.config;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

	@Value("${keycloak.realmname}")
	String aipRealmName;
	
	@Value("${keycloak.clientname}")
	String aipClientId;
    
	@Bean
	public Keycloak aipKeycloakClient() {
		
		Keycloak keycloakClient = KeycloakBuilder.builder()
				.serverUrl("http://localhost:8080/auth")
				.grantType(OAuth2Constants.PASSWORD)
				.realm(aipRealmName)
				.clientId(aipClientId)
				.clientSecret("bf56a959-5d5e-457d-a781-8ffcd6cd159e")
//				.username("gichul.hong")
				.username("aip-admin")
				.password("1234")
				.resteasyClient(
						new ResteasyClientBuilder()
						.connectionPoolSize(10).build()
						).build();
		
		return keycloakClient;
	}
	
//	@Bean
//	public RealmResource aipRealm(Keycloak aipKeycloakClient) {
//		
//		return aipKeycloakClient.realm("aip");
//	}
	
}
