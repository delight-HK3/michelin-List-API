package com.api.michelinAPI.entity;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 일본 미쉐린 가이드 Entity
 */

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "michelin_List_jp")
public class MichelinJpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEQ")
    @Comment(value = "일련번호")
    private int seq;                    // 일련번호

    @Column(name = "MICHELIN_NM")
    @Comment(value = "미슐랭명")
    private String michelinNm;          // 미슐랭명

    @Column(name = "FCLTY_NM")
    @Comment(value = "레스토랑이름")
    private String fcltyNm;             // 레스토랑이름

    @Column(name = "RDNMADR_NM")
    @Comment(value = "도로명주소")
    private String rdnmadrNm;           // 도로명주소
    
    @Column(name = "CTPRVN_ENG_NM")
    @Comment(value = "시도영문명")
    private String ctprvnEngNm;         // 시도영문명 
    
    @Column(name = "FCLTY_LO")
    @Comment(value = "위도")
    private double fcltyLo;             // 위도
    
    @Column(name = "FCLTY_LA")
    @Comment(value = "경도")
    private double fcltyLa;             // 경도
    
    @Column(name = "STAR_CNT")
    @Comment(value = "별 개수")
    private int starCnt;                // 별 개수
    
    @Column(name = "EVALUATION_YEAR")
    @Comment(value = "년도")
    private int year;                   // 년도

    @Column(name = "FOOD_CATG")
    @Comment(value = "식사카테고리")
    private String foodCatg;            // 식사카테고리

    @Column(name = "SUSTAINABILITY")
    @Comment(value = "지속가능성")
    private int sustainability;         // 지속가능성
}
