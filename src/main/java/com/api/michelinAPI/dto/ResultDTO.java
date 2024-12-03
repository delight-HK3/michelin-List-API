package com.api.michelinAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResultDTO {
    
    private final String michelinNm;      // 미슐랭명
    private final String fcltyNm;         // 레스토랑이름
    private final String rdnmadrNm;       // 도로명주소
    private final String ctprvnEngNm;     // 시도영문명
    private final double fcltyLo;         // 위도
    private final double fcltyLa;         // 경도
    private final int starCnt;            // 별 개수
    private final int year;               // 획득년도
    private final String foodCatg;        // 식사카테고리
    private final int sustainAbility;     // 지속가능성

}
