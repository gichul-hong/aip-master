package com.sec.aip.aipmaster.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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

import com.sec.aip.aipmaster.common.exception.AipErrorCode;
import com.sec.aip.aipmaster.common.exception.AipException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeycloakAdminService {

	final private RealmResource aipRealm;

	/**
	 * Generating default groups per project
	 *   - Groups/aip/project/{projectName}
	 *   - Groups/aip/project/{projectName}/admin for admin users
	 * @param projectName
	 * @param projectAdminId
	 */
	public void initializeGroupAndRole(String projectName, String projectAdminId) {
		// TODO 그런데 프로젝트명은 무엇으로 하는가... 
//		createGroup(projectName, KeycloakNamingHelper.AIP_PROJECT_GROUP_ROOT_PATH);
//		createGroup(KeycloakNamingHelper.AIP_ADMIN_GROUP_NAME, KeycloakNamingHelper.getProjectGroupPath(projectName));
		
//		createGroup("pjt3", "/aip");
		createGroup("pjt4", "aip");
		createGroup("pjt5", "/aip/");
		
		
	}
	
	/**
	 * create project default groups in {realm} 
     *   - aip/project/{projectName}
     *   - aip/project/{projectName}/admin
	 * @param projectPath 
	 * @param groupId
	 */
	public void createGroup(String projectName, String projectPath) {
		
//		GroupsResource aipGroups = aipRealm.groups();
		
		GroupRepresentation newGroup = new GroupRepresentation();
		newGroup.setName(projectName);
//		newGroup.setPath(projectPath);
		
//		aipRealm.groups().add(newGroup);
		
		aipRealm.getGroupByPath("\\/aip\\/projects").setSubGroups(List.of(newGroup));
		
		Response response = aipRealm.groups().group("/aip/projects").subGroup(newGroup);
//		Response response = aipRealm.groups().add(newGroup);
		
		// TODO 에러처리를 이렇게 해야하나 ;;;
		if (response.getStatus() != Status.CREATED.getStatusCode()) {
		    throw new AipException(response.getStatusInfo().getReasonPhrase() ,AipErrorCode.EXAMPLE_ERROR);
		}
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
		
		GroupsResource aipGroups = aipRealm.groups();
		List<GroupRepresentation> groupList = aipGroups.groups();
		
	    GroupRepresentation group = groupList.get(0);
	    log.debug(group.getName(), group.getAccess(), group.getPath());		
		return null;
	}
	
	public RolesResource getRoleList() {

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
