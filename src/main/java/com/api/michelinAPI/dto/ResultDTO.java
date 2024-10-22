package com.api.michelinAPI.dto;

import com.api.michelinAPI.entity.MichelinJpEntity;
import com.api.michelinAPI.entity.MichelinKrEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResultDTO {
    
    private String michelinNm;      // 미슐랭명
    private String fcltyNm;         // 레스토랑이름
    private String rdnmadrNm;       // 도로명주소
    private String ctprvnEngNm;     // 시도영문명
    private String foodCatg;        // 식사카테고리
    private double fcltyLo;         // 위도
    private double fcltyLa;         // 경도
    private int starCnt;        // 별 개수
    private int year;           // 획득년도
    
    // MichelinKrEntity -> DTO (목록보기)
    public static ResultDTO toListKrDTO(MichelinKrEntity entity){
        return ResultDTO.builder()
                        .michelinNm(entity.getMichelinNm())
                        .fcltyNm(entity.getFcltyNm())
                        .rdnmadrNm(entity.getRdnmadrNm())
                        .ctprvnEngNm(entity.getCtprvnEngNm())
                        .foodCatg(entity.getFoodCatg())
                        .fcltyLo(entity.getFcltyLo())
                        .fcltyLa(entity.getFcltyLa())
                        .starCnt(entity.getStarCnt())
                        .year(entity.getYear())
                        .build();
    }
    
    // MichelinJpEntity -> DTO (목록보기)
    public static ResultDTO toListJpDTO(MichelinJpEntity entity){
        return ResultDTO.builder()
                        .michelinNm(entity.getMichelinNm())
                        .fcltyNm(entity.getFcltyNm())
                        .rdnmadrNm(entity.getRdnmadrNm())
                        .ctprvnEngNm(entity.getCtprvnEngNm())
                        .foodCatg(entity.getFoodCatg())
                        .fcltyLo(entity.getFcltyLo())
                        .fcltyLa(entity.getFcltyLa())
                        .starCnt(entity.getStarCnt())
                        .year(entity.getYear())
                        .build();
    }
}
