
package com.sec.aip.aipmaster.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sec.aip.aipmaster.common.dto.github.GithubOrg;

@Service
public class GithubService {
    
    public List<GithubOrg> getOrgList() {
        
        return new ArrayList<>();
    };

    public boolean canCreateOrgAndRepo(String projectName) {
        
        return true;
    }

    public void createOrgAndRepo(String projectName, String projectAdminId) {
        
    }

}
