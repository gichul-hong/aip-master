package com.sec.aip.aipmaster.common.util;

public class KeycloakNamingHelper {
	
	public static final String AIP_PROJECT_GROUP_ROOT_PATH = "/aip/projects/";
	public static final String AIP_ADMIN_GROUP_NAME = "admin";
	public static final String GROUP_DELIMITER = "/";
	
	public static String getProjectGroupPath(String projectName ) {
		
		return new StringBuffer(AIP_PROJECT_GROUP_ROOT_PATH)
				.append(GROUP_DELIMITER)
				.append(projectName)
				.append(GROUP_DELIMITER)
				.toString();
	}
	
	public static String getProjectAdminGroupPath(String projectName) {
		
		return new StringBuffer(getProjectGroupPath(projectName))
				.append(GROUP_DELIMITER)
				.append(AIP_ADMIN_GROUP_NAME)
				.append(GROUP_DELIMITER)
				.toString();
	}

}
