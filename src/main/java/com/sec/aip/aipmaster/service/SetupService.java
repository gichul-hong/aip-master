package com.sec.aip.aipmaster.service;

import org.springframework.stereotype.Service;

import com.sec.aip.aipmaster.common.exception.AipErrorCode;
import com.sec.aip.aipmaster.common.exception.AipException;
import com.sec.aip.aipmaster.model.AipProject;
import com.sec.aip.aipmaster.repository.AipProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SetupService {

    final private AipProjectRepository projectRepository;
    final private GithubService githubService;
    final private S3Service s3Service;
    final private HarborService harborService;
    
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
        
        
    }}
