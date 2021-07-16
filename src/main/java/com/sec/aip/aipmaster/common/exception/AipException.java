package com.sec.aip.aipmaster.common.exception;

public class AipException extends RuntimeException {

    private static final long serialVersionUID = -3421652180228104247L;
    
    private AipErrorCode error;
    
    public AipException(String message, AipErrorCode error) {
        
        super(message);
        this.error = error;
    }
    
    public AipException(AipErrorCode error) {
        
        this.error = error;
    }
    
    public AipErrorCode getError() {
        
        return error;
    }

}
