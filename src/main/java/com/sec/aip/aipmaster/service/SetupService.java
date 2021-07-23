package com.sec.aip.aipmaster.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sec.aip.aipmaster.common.exception.AipErrorCode;
import com.sec.aip.aipmaster.common.exception.AipException;
import com.sec.aip.aipmaster.model.AipProject;
import com.sec.aip.aipmaster.model.AipUser;
import com.sec.aip.aipmaster.repository.AipProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SetupService {

    final private AipProjectRepository projectRepository;
    final private GithubService githubService;
    final private S3Service s3Service;
    final private HarborService harborService;
    final private AuthService authService;
    final private KeycloakAdminService keycloakAdminService;
    
    public boolean canCreateProject(String projectName) {

    	if (projectRepository.findByProjectName(projectName).isPresent()) {
    		
    		throw new AipException(AipErrorCode.PROJECT_NAME_EXISTS);
    	}
        
        if (!githubService.canCreateOrgAndRepo(projectName)) {
            
        	throw new AipException(AipErrorCode.GITHUB_ERROR);
        }
        
        if (!s3Service.canCreateBucket(projectName)) {
            
        	throw new AipException(AipErrorCode.S3_ERROR);
        }
        
        if (!harborService.canCreatePrivateRepo(projectName)) {
            
        	throw new AipException(AipErrorCode.HARBOR_ERROR);
        }
        
        return true;
    }
    
    public void initializerProject(String projectName, String projectAdminId, String description) {
        
        AipProject project = AipProject.builder()
                                 .projectName(projectName)
                                 .description(description)
                                 .build();
        
        projectRepository.save(project);
        
        githubService.createOrgAndRepo(projectName, projectAdminId);
        
        s3Service.createBucket(projectName);
        
//        keycloakAdminService.initializeGroupAndRole(projectName, projectAdminId);
        
        
    }

    public AipProject getProjectByProjectId(int projectId) {

    	return projectRepository.findById(projectId)
    			.orElseThrow(() -> new AipException(AipErrorCode.DATA_NOT_FOUND));
    }    	
    
	public AipProject getProjectByProjectName(String projectName) {

		return projectRepository.findByProjectName(projectName)
				.orElseThrow(() -> new AipException(AipErrorCode.DATA_NOT_FOUND));
	}


	public void addMemberToProject(int projectId, String memberId) {
		
		AipProject project = getProjectByProjectId(projectId);
		AipUser user = authService.getUserInfo();
		
		// TODO
		// DB에 추가, git 등에 멤버 추가, 멤버를 list 로 받는 것도 고려해야 
		
	}

	public void removeMemberFromProject(int projectId, String id) {

		AipProject project = getProjectByProjectId(projectId);
		AipUser user = authService.getUserInfo();
		
		// TODO
		// DB에서 삭, git 등에 멤버 추가, 멤버를 list 로 받는 것도 고려해야 

	}

	public List<AipProject> getProjectList() {
		
		return projectRepository.findAll();
	}
}
