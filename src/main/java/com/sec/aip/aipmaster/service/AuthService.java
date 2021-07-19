package com.sec.aip.aipmaster.service;

import org.springframework.stereotype.Service;

import com.sec.aip.aipmaster.model.AipUser;

@Service
public class AuthService {

    public String getAuthToken() {
        
        
        return "testToken";
    }
    
    public AipUser getUserInfo() {
    	
        return AipUser.builder()
        		.userId("gichul.hong")
        		.email("gichul.hong@samsung.com")
        		.password("password")
        		.projectUser(null)
        		.build();
//        throw new AipException(AipErrorCode.USER_NOT_FOUND);
    }

    
}
