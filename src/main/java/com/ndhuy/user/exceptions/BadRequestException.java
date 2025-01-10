package com.ndhuy.user.exceptions;

public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 1905122041950251207L;
    private final String errorCode;
    private final Object[] ar; 

    public BadRequestException(String errorCode) {
        this.errorCode = errorCode;
        this.ar = null;
    }

    public BadRequestException(String errorCode, Object... ar) {
        this.errorCode = errorCode;
        this.ar = ar;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Object[] getAr() {
        return ar;
    }
}
