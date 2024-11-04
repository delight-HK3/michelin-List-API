package com.api.michelinAPI.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum exceptionEnum {
    
    // parameter 잘못 입력시
    PARAMETER_TYPE_ERROR(HttpStatus.BAD_REQUEST, "12", "PARAMETER TYPE ERROR"),
    // URL을 잘못 입력시
    NO_RESOURCE_ERROR(HttpStatus.BAD_REQUEST,"404","NO RESOURCE ERROR"),
    // 필수파라미터를 입력안한 경우
    NO_MANDATORY_REQUEST_PARAMETERS_ERROR(HttpStatus.BAD_REQUEST ,"11","NO MANDATORY REQUEST PARAMETERS ERROR"),
    // 데이터베이스 에러시
    DB_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"02","DB ERROR"),
    // 조회시 데이터가 없으면 발동
    NODATA_ERROR(HttpStatus.NOT_FOUND,"03","NODATA ERROR");

    private final HttpStatus status;
    private final String code;
    private String message;

    exceptionEnum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
