package com.api.michelinAPI.dto;

import com.api.michelinAPI.entity.MichelinJpEntity;
import com.api.michelinAPI.entity.MichelinKrEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResultDTO {
    
    private final String michelinNm;      // 미슐랭명
    private final String fcltyNm;         // 레스토랑이름
    private final String rdnmadrNm;       // 도로명주소
    private final String ctprvnEngNm;     // 시도영문명
    private final String foodCatg;        // 식사카테고리
    private final double fcltyLo;         // 위도
    private final double fcltyLa;         // 경도
    private final int starCnt;            // 별 개수
    private final int year;               // 획득년도
    private final int sustainability;     // 지속가능성

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
                        .sustainability(entity.getSustainability())
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
                        .sustainability(entity.getSustainability())
                        .build();
    }

}
