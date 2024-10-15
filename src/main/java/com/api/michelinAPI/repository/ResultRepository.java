package com.api.michelinAPI.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.michelinAPI.dto.paramDTO;

import com.api.michelinAPI.entity.MichelinEntity;
import com.api.michelinAPI.entity.QMichelinEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ResultRepository{
    
    // QueryDSL
    private final JPAQueryFactory queryFactory;
    
    // QMichelinEntity 등록
    QMichelinEntity michelinEntity = QMichelinEntity.michelinEntity; 

    public List<MichelinEntity> findMichelinList(paramDTO dto){
        return queryFactory.from(michelinEntity) 
                            .select(michelinEntity)
                            .where(
                                equalStarCnt(dto.getStarCnt())
                                , equalFcltyNm(dto.getFcltyNm())
                                , equalYear(dto.getYear())
                                , equalCtprvnEngNm(dto.getCtprvnEngNm())
                            )
                            .limit(dto.getRow())
                            .fetch(); 
    }

    // 별개수 지정 메서드
    private BooleanExpression equalStarCnt(Integer starCnt){
        return starCnt != null ? michelinEntity.starCnt.eq(starCnt) : null;
    } 

    // 레스토랑이름 메서드
    private BooleanExpression equalFcltyNm(String fcltyNm){
        return fcltyNm != null ? michelinEntity.fcltyNm.eq(fcltyNm) : null;
    } 
    
    // 년도 체크 메서드
    private BooleanExpression equalYear(Integer year){
        return year != null ? michelinEntity.year.eq(year) : null;
    } 

    // 시도영문명 메서드
    private BooleanExpression equalCtprvnEngNm(String ctprvnEngNm){
        return ctprvnEngNm != null ? michelinEntity.ctprvnEngNm.eq(ctprvnEngNm) : null;
    } 
}
