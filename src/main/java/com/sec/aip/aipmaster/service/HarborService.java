package com.sec.aip.aipmaster.service;

import java.util.List;

import com.sec.aip.aipmaster.common.dto.harbor.HarborProject;
import com.sec.aip.aipmaster.common.dto.harbor.HarborProjectMember;

public interface HarborService {

    public List<HarborProject> getProjectLists();
    
    public void createProject(String projectName);
    
    public HarborProject getProject(int projectId);
    
    public HarborProject getProjectByName(String projectName);
    
    public HarborProjectMember getHarborProjectMembers(int projectId);
    
    public int createMember(String userName);
    
    public void addProjectMember(int projectId, int memberId);
}
