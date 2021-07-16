package com.sec.aip.aipmaster.common.exception;

import lombok.Getter;

@Getter
public enum AipErrorCode {

    USER_NOT_FOUND("C0001", "User not found."),
    EXAMPLE_ERROR("X9999", "This is Sparta!");
    
    private String code;
    private String message;
    
    AipErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
}
