package com.sec.aip.aipmaster.service;

import java.util.List;

import org.keycloak.admin.client.resource.ClientsResource;
import org.keycloak.admin.client.resource.GroupsResource;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeycloakAdminService {

//	private Keycloak keycloakClient;
	final private RealmResource aipRealm;

	/**
	 * create project default groups in {realm} 
     *   - aip/project/{projectName}
     *   - aip/project/{projectName}/admin
	 * @param groupId
	 */
	public void createProjectGroup(String projectName) {
		
		String groupString = aipRealm.groups().toString();
		
		aipRealm.addDefaultGroup(projectName);
	}
	
	public void addUserToGroup(String userId, String groupId) {
		
		aipRealm.users().get(userId).joinGroup(groupId);
	}
	
	public void createClientRole(String roleId, String clientId) {
		
	}
	
	public void addUserToClientRole(String userId, String roleId, String clientId) {
		
	}
	
	public void addGroupToClientRole(String groupId, String roleId) {
		
	}
	
	public List<GroupRepresentation> getGroupList() {
		
		aipRealm.groups().count();
		
		GroupsResource aipGroups = aipRealm.groups();
		List<GroupRepresentation> groupList = aipGroups.groups();
		
		groupList.forEach(System.out::println);
		
		System.out.println(groupList.toString());
		
		return null;
	}
	
	private RolesResource getRoleList() {

		ClientsResource clients = aipRealm.clients();
		UsersResource userResource = aipRealm.users();
		
		ClientRepresentation clientRep = clients.findByClientId("aip-master").get(0);
		
		return aipRealm.clients().get("aip-master").roles();
	}
	
	private RoleRepresentation getRoleRepresentation(String roleName) {
		
		return getRoleList().get(roleName).toRepresentation();
		
	}
	
	public void addUserToRole(String userId, String roleId) {
		
	}
	
	/**
	 * 요것은 그냥 테스트 용도였읍니다. yujeoug.hong은 samsung.com 하면 아니됩니다. 
	 */
	@Deprecated
	private void createKeycloakUser(String id, String email) {
		
		UsersResource userResource = aipRealm.users();
		
		UserRepresentation user = new UserRepresentation();
		
        user.setUsername("yujeong.hong");
        user.setFirstName("yujeong");
        user.setLastName("hong");
        user.setEmail("yujeong.hong@samsung.com");
//        user.setAttributes(Collections.singletonMap("origin", Arrays.asList("demo")));
        
        javax.ws.rs.core.Response response = userResource.create(user);
        log.debug(response.getStatusInfo().toString());
	}
	
	private UserResource getUserById(String userId) {
		
		return aipRealm.users().get(userId);
		
	}
	
	
}
