package com.sec.aip.aipmaster.common.dto.harbor;

import lombok.Data;

@Data
public class User {

    private int userId;
    private String username;
    private String email;
    private String realname;
    private boolean deleted;
    
    private String roleName;
    private int roleId;

}
