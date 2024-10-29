package com.api.michelinAPI.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * version 1.0
 * 최초 생성 : 2024.10.04
 * 설명 : exception 처리 class
 */

@Slf4j
@RestControllerAdvice
public class exceptionHandler {

    /**
     * parameter 잘못 입력시 발동하는 Hander
     * 
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<errorResponse> validError(MethodArgumentNotValidException e, HttpServletRequest request){
        log.warn("PARAMETER TYPE ERROR!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());
        errorResponse errorResult = new errorResponse("12", "PARAMETER TYPE ERROR");

        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }

    /**
     * URL을 잘못 입력시 발동하는 Hander
     * 
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<errorResponse> NoResourceFoundError(NoResourceFoundException e, HttpServletRequest request){
        log.warn("NO RESOURCE ERROR!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());
        errorResponse errorResult = new errorResponse("404", "NO RESOURCE ERROR");

        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }

    /**
     * 필수파라미터를 입력안한 경우
     * 
     * @param e
     * @param request
     * @return
     */

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<errorResponse> NullPointerException(NullPointerException e, HttpServletRequest request){
        log.warn("NO_MANDATORY_REQUEST_PARAMETERS_ERROR!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());
        errorResponse errorResult = new errorResponse("11", "NO_MANDATORY_REQUEST_PARAMETERS_ERROR");
        
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }


    /**
     * 데이터베이스 에러시 발동하는 Hander
     * 
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler({DataAccessException.class})
    public ResponseEntity<errorResponse> handleSQLException(DataAccessException e, HttpServletRequest request){
        log.warn("DB ERROR!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());
        errorResponse errorResult = new errorResponse("02", "DB ERROR");
        
        return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 데이터베이스 조회시 데이터가 없으면 발동하는 Hander
     * 
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(NoDataException.class)
    public ResponseEntity<errorResponse> handleNoDataException(NoDataException e, HttpServletRequest request) {
        log.warn("NODATA ERROR!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());
        errorResponse errorResult = new errorResponse("03", "NODATA ERROR");
        
        return new ResponseEntity<>(errorResult, HttpStatus.NOT_FOUND);
    }

}
