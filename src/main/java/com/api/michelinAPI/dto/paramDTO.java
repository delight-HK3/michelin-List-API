package com.api.michelinAPI.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
