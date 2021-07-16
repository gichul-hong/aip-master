
package com.sec.aip.aipmaster.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface GithubService {
    
    public List<GithubOrg> getOrgList();

}
