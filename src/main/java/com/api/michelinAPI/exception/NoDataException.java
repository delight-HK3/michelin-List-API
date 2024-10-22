package com.api.michelinAPI.exception;

public class NoDataException extends RuntimeException{
    public NoDataException() {
        super();
    }

    public NoDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
