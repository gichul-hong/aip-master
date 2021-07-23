package com.sec.aip.aipmaster.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.keycloak.admin.client.resource.RoleResource;
import org.keycloak.representations.idm.GroupRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KeycloakAdminServiceTest {

	Logger logger = LoggerFactory.getLogger(KeycloakAdminServiceTest.class);
	
	@Resource
	KeycloakAdminService keycloakAdminService;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void getGroupListTest() {
	
		List<GroupRepresentation> groups = keycloakAdminService.getGroupList();
		
//		groups.forEach(null);
		
	}
	
//	@Test
//	void createProjectGroupTest () {
//
//		try {
//			
//			keycloakAdminService.createProjectGroup("pjt1");
// 		} catch (Exception ex ) {
// 			ex.printStackTrace();
// 		}
//
//	}
	
	@Test 
	void initializeGroupAndRoleTest() {
		
		String newProjectName = "pjt3";
		
		keycloakAdminService.initializeGroupAndRole(newProjectName, null);
		
		
		
	}
	
}
