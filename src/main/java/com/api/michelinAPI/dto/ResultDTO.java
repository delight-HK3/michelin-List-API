package com.api.michelinAPI.dto;

import com.api.michelinAPI.entity.ResultEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultDTO {
    
    private String michelinNm;      // 미슐랭명
    private String fcltyNm;         // 레스토랑이름
    private String rdnmadrNm;       // 도로명주소
    private String ctprvnEngNm;     // 시도영문명 
    private double fcltyLo;         // 위도
    private double fcltyLa;         // 경도
    private int starCnt;            // 별 개수
    private int year;               // 획득년도
    
    // entity -> DTO (게시글 목록보기)
    public static ResultDTO toListDTO(ResultEntity entity){
        return ResultDTO.builder()
                        .michelinNm(entity.getMichelinNm())
                        .fcltyNm(entity.getFcltyNm())
                        .rdnmadrNm(entity.getRdnmadrNm())
                        .ctprvnEngNm(entity.getCtprvnEngNm())
                        .fcltyLo(entity.getFcltyLo())
                        .fcltyLa(entity.getFcltyLa())
                        .starCnt(entity.getStarCnt())
                        .year(entity.getYear())
                        .build();
    }
}
