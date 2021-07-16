package com.sec.aip.aipmaster.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sec.aip.aipmaster.common.dto.harbor.HarborProject;
import com.sec.aip.aipmaster.common.dto.harbor.HarborProjectMember;

@Service
public class HarborService {

    public boolean canCreatePrivateRepo(String projectName) {
        
        return true;
    }

    public List<HarborProject> getProjectLists() {
        
        return new ArrayList<>();
    }
    
    public void createProject(String projectName) {
        
    }
    
    public HarborProject getProject(int projectId) {
        
        return new HarborProject();
    }
    
    public HarborProject getProjectByName(String projectName) {
        
        return new HarborProject();
    }
    
    public List<HarborProjectMember> getHarborProjectMembers(int projectId) {
        
        return new ArrayList<>();
    }
    
//    public int createMember(String userName);
//    
//    public void addProjectMember(int projectId, int memberId);

}
