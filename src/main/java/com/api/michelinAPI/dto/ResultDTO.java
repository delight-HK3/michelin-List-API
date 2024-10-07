package com.api.michelinAPI.dto;

import lombok.Data;

@Data
public class ResultDTO {
    
    private String michelinNm;      // 미슐랭명
    private String fcltyNm;         // 레스토랑이름
    private String rdnmadrNm;       // 도로명주소
    private String ctprvnEngNm;     // 시도영문명 
    private double fcltyLo;         // 위도
    private double fcltyLa;         // 경도
    private int starCnt;            // 별 개수
    private int year;               // 획득년도
    
}
