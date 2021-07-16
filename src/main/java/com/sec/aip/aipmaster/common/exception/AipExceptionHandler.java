package com.sec.aip.aipmaster.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sec.aip.aipmaster.common.dto.DefaultResponse;
import com.sec.aip.aipmaster.common.dto.Message;
import com.sec.aip.aipmaster.common.dto.AipResponseStatus;

@RestControllerAdvice
public class AipExceptionHandler {

    @ExceptionHandler(value = AipException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<DefaultResponse<?>> handleAipException(AipException ex) {
        
        Message message = new Message();
        message.setCode(ex.getError().getCode());
        message.setMessage(ex.getError().getMessage());
        message.setData(null);
        
        return new ResponseEntity<DefaultResponse<?>>(DefaultResponse.of(AipResponseStatus.BAD_REQUEST, message), HttpStatus.OK);
    }
}