package com.sec.aip.aipmaster.common.dto;

import lombok.Data;

@Data
public class Message {

    private String code;
    private String message;
    private Object data;

}