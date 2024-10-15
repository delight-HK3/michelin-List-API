package com.api.michelinAPI.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "michelin_List")
public class ResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEQ")
    private int seq;                    // 일련번호

    @Column(name = "MICHELIN_NM")
    private String michelinNm;          // 미슐랭명

    @Column(name = "FCLTY_NM")
    private String fcltyNm;             // 레스토랑이름

    @Column(name = "RDNMADR_NM")
    private String rdnmadrNm;           // 도로명주소
    
    @Column(name = "CTPRVN_ENG_NM")
    private String ctprvnEngNm;         // 시도영문명 
    
    @Column(name = "FCLTY_LO")
    private double fcltyLo;             // 위도
    
    @Column(name = "FCLTY_LA")
    private double fcltyLa;             // 경도
    
    @Column(name = "STAR_CNT")
    private int starCnt;                // 별 개수
    
    @Column(name = "EVALUATION_YEAR")
    private int year;                   // 년도

}
