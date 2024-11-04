package com.api.michelinAPI.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import lombok.extern.slf4j.Slf4j;

/**
 * version 1.0
 * 최초 생성 : 2024.10.04
 * 설명 : exception 처리 class
 */

@Slf4j
@RestControllerAdvice
public class exceptionHandler{

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<errorResponse> parameterError(final MethodArgumentNotValidException e){
        String message = getExceptionMessage(e.getMessage());
        StackTraceElement[] stackTraceElement = e.getStackTrace();
        log.error(message, stackTraceElement[0]);
        
        return ResponseEntity
                .status(exceptionEnum.PARAMETER_TYPE_ERROR.getStatus())
                .body(errorResponse.builder()
                        .errorCode(exceptionEnum.PARAMETER_TYPE_ERROR.getCode())
                        .errorMessage(exceptionEnum.PARAMETER_TYPE_ERROR.getMessage())
                        .build());
    }

    @ExceptionHandler({NoResourceFoundException.class})
    public ResponseEntity<errorResponse> NoResourceFoundError(final NoResourceFoundException e){
        String message = getExceptionMessage(e.getMessage());
        StackTraceElement[] stackTraceElement = e.getStackTrace();
        log.error(message, stackTraceElement[0]);
        
        return ResponseEntity
                .status(exceptionEnum.NO_RESOURCE_ERROR.getStatus())
                .body(errorResponse.builder()
                        .errorCode(exceptionEnum.NO_RESOURCE_ERROR.getCode())
                        .errorMessage(exceptionEnum.NO_RESOURCE_ERROR.getMessage())
                        .build());
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<errorResponse> NullPointerException(final NullPointerException e){
        String message = getExceptionMessage(e.getMessage());
        StackTraceElement[] stackTraceElement = e.getStackTrace();
        log.error(message, stackTraceElement[0]);
        
        return ResponseEntity
                .status(exceptionEnum.NO_MANDATORY_REQUEST_PARAMETERS_ERROR.getStatus())
                .body(errorResponse.builder()
                        .errorCode(exceptionEnum.NO_MANDATORY_REQUEST_PARAMETERS_ERROR.getCode())
                        .errorMessage(exceptionEnum.NO_MANDATORY_REQUEST_PARAMETERS_ERROR.getMessage())
                        .build());
    }

    @ExceptionHandler({DataAccessException.class})
    public ResponseEntity<errorResponse> handleSQLException(final DataAccessException e){
        String message = getExceptionMessage(e.getMessage());
        StackTraceElement[] stackTraceElement = e.getStackTrace();
        log.error(message, stackTraceElement[0]);

        return ResponseEntity
                .status(exceptionEnum.DB_ERROR.getStatus())
                .body(errorResponse.builder()
                        .errorCode(exceptionEnum.DB_ERROR.getCode())
                        .errorMessage(exceptionEnum.DB_ERROR.getMessage())
                        .build());
    }

    @ExceptionHandler({NoDataException.class})
    public ResponseEntity<errorResponse> handleNoDataException(final NoDataException e) {
        String message = getExceptionMessage(e.getMessage());
        StackTraceElement[] stackTraceElement = e.getStackTrace();
        log.error(message, stackTraceElement[0]);

        return ResponseEntity
                .status(e.getError().getStatus())
                .body(errorResponse.builder()
                        .errorCode(e.getError().getCode())
                        .errorMessage(e.getError().getMessage())
                        .build());
    }

    private static String getExceptionMessage(String message){
        if(StringUtils.hasText(message)){
            return message + "\n \t {}";
        }
        return "\n \t {}";
    }

}
