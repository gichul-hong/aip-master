package com.sec.aip.aipmaster.common.dto.harbor;

import lombok.Data;

@Data
public class HarborProjectMember {

    private int mid;
    private int projectId;
    
    private String entityName;
    private String roleName;
    private int roleId;
    
    private int entityId;
    private String entityType;
}
