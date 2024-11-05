package com.api.michelinAPI.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    
    @NotNull
    private Integer row;            // 데이터 행 수

    private String fcltynm;         // 레스토랑이름
    private Integer starcnt;        // 별 개수

    @Pattern(regexp = "^[a-zA-Z]+$")
    private String ctprvnengnm;     // 시도영문명
    
    private Integer year;           // 년도
    private Integer sustainability; // 지속가능성
}   
