
package com.sec.aip.aipmaster.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sec.aip.aipmaster.common.dto.github.GithubOrg;

@Service
public interface GithubService {
    
    public List<GithubOrg> getOrgList();

}
