
package com.sec.aip.aipmaster.common.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AipException extends RuntimeException {

    private static final long serialVersionUID = -3421652180228104247L;
    
    private AipErrorCode error;
    
    public AipException(String message, AipErrorCode error) {
        
        super(message);
        this.error = error;
        
        log.debug("NEW AipException {} : {}", error.getCode(), message);
    }
    
    public AipException(AipErrorCode error) {
        
        this.error = error;
        log.debug("NEW AipException {} : {}", error.getCode(), null);
    }
    
    public AipErrorCode getError() {
        
        return error;
    }

}
