package com.api.michelinAPI.exception;

import lombok.Getter;

@Getter
public class NoDataException extends RuntimeException{
    private exceptionEnum error;

    public NoDataException() {
        super();
    }

    public NoDataException(exceptionEnum e) {
        super(e.getMessage());
        this.error = e;
    }
}
