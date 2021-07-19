package com.sec.aip.aipmaster.common.dto;

import lombok.Getter;

/**
 * 
 * @author mdipok
 * 이게 의미가 있나..
 */
@Getter
public enum AipResponseStatus {

    OK(200, "OK"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    INTERNAL_SERER_ERROR(500, "INTERNAL_SERVER_ERROR");

    int statusCode;
    String code;

    AipResponseStatus(int statusCode, String code) {
        this.statusCode = statusCode;
        this.code = code;
    }
}