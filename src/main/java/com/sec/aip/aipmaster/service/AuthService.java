package com.sec.aip.aipmaster.service;

import org.springframework.stereotype.Service;

import com.sec.aip.aipmaster.common.exception.AipErrorCode;
import com.sec.aip.aipmaster.common.exception.AipException;
import com.sec.aip.aipmaster.model.AipUser;

@Service
public class AuthService {

    public String getAuthToken() {
        
        
        return "testToken";
    }
    
    public AipUser getUserInfo() {
//        return new AipUser("id", "password", "name");
        throw new AipException(AipErrorCode.USER_NOT_FOUND);
    }

    
}
