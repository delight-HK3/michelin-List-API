package com.api.michelinAPI.dto;

import lombok.Data;

@Data
public class paramDTO {
    
    private Integer row;             // 데이터 행 수
    private String fcltyNm;          // 레스토랑이름
    private Integer starCnt;         // 별 개수
    private Integer year;            // 획득년도
    private String ctprvnEngNm;      // 시도영문명 
}   
