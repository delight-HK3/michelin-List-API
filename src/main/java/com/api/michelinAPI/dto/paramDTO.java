package com.api.michelinAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 생성
public class paramDTO {
    
    private Integer row;            // 데이터 행 수
    private String fcltyNm;         // 레스토랑이름
    private Integer starCnt;        // 별 개수
    private Integer year;           // 획득년도
    private String ctprvnEngNm;     // 시도영문명 

}   
