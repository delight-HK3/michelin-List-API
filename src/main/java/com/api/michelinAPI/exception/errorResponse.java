package com.api.michelinAPI.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class errorResponse {
    private String errorCode;
	private String errorMessage;

    @Builder
    public errorResponse(HttpStatus status, String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
