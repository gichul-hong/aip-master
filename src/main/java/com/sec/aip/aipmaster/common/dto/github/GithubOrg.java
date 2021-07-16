package com.sec.aip.aipmaster.common.dto.github;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GithubOrg {


    private String login;
    private int id;
    
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("repos_url")
    private String reposUrl;
    @JsonProperty("members_url")
    private String membersUrl;
    @JsonProperty("public_memgers_url")
    private String publicMembersUrl;
    
    private String description;
}
