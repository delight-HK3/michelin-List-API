package com.api.michelinAPI.exception;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.api.michelinAPI.dto.errorResultDTO;

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
    public ResponseEntity<errorResultDTO> validError(MethodArgumentNotValidException e, HttpServletRequest request){
        log.warn("PARAMETER TYPE ERROR!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());
        errorResultDTO errorResult = new errorResultDTO("12", "PARAMETER TYPE ERROR");

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
    public ResponseEntity<errorResultDTO> NoResourceFoundError(NoResourceFoundException e, HttpServletRequest request){
        log.warn("NO RESOURCE ERROR!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());
        errorResultDTO errorResult = new errorResultDTO("404", "NO RESOURCE ERROR");

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
    public ResponseEntity<errorResultDTO> NullPointerException(NullPointerException e, HttpServletRequest request){
        log.warn("NO_MANDATORY_REQUEST_PARAMETERS_ERROR!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());
        errorResultDTO errorResult = new errorResultDTO("11", "NO_MANDATORY_REQUEST_PARAMETERS_ERROR");
        
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }


    /**
     * 데이터베이스 에러시 발동하는 Hander
     * 
     * @param e
     * @param request
     * @return
     */
    // 현재 데이터조회시 row가 0이면 이쪽 Exception을 지나도록 되게 했지만 customException이 필요
    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public ResponseEntity<errorResultDTO> handleSQLException(Exception e, HttpServletRequest request){
        log.warn("DB ERROR!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());
        errorResultDTO errorResult = new errorResultDTO("02", "DB ERROR");

        return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
