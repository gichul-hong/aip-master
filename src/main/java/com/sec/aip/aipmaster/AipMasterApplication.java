package com.sec.aip.aipmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sec.aip.aipmaster.common.properties.KeycloakJsonProperties;

@SpringBootApplication
@ComponentScan(basePackageClasses = { KeycloakJsonProperties.class})
public class AipMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AipMasterApplication.class, args);
	}

}
