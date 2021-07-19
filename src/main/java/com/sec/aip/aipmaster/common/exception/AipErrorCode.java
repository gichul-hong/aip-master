package com.sec.aip.aipmaster.common.exception;

import lombok.Getter;

@Getter
public enum AipErrorCode {

    USER_NOT_FOUND("C0001", "User not found."),
    DATA_NOT_FOUND("C0002", "Data not found"),
    
    PROJECT_NAME_EXISTS("S0001", "Project Already Exists"),
    GITHUB_ERROR("S0002", "Github error, change me"),
    HARBOR_ERROR("S0003", "Harbor error, change me"),
    S3_ERROR("S0004", "S3 error, change me"),
    
    EXAMPLE_ERROR("X9999", "This is Sparta!");
    
    private String code;
    private String message;
    
    AipErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
}
