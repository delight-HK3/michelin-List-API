package com.api.michelinAPI.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.michelinAPI.dto.paramDTO;
import com.api.michelinAPI.entity.MichelinKrEntity;
import com.api.michelinAPI.entity.QMichelinKrEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class MichelinKrRepository{
    
    // QueryDSL
    private final JPAQueryFactory queryFactory;
    
    MichelinKrRepository(JPAQueryFactory queryFactory){   
        this.queryFactory = queryFactory;
    }

    // QMichelinKrEntity 등록
    QMichelinKrEntity michelinKrEntity = QMichelinKrEntity.michelinKrEntity;
    
    public List<MichelinKrEntity> findMichelinList(paramDTO dto){
        return queryFactory.from(michelinKrEntity) 
                            .select(michelinKrEntity)
                            .where(
                                equalStarCnt(dto.getStarCnt())
                                , equalFcltyNm(dto.getFcltyNm())
                                , equalYear(dto.getYear())
                                , equalCtprvnEngNm(dto.getCtprvnEngNm())
                            )
                            .limit(dto.getRow())
                            .fetch(); 
    }

    // 별개수 체크 메서드
    private BooleanExpression equalStarCnt(Integer starCnt){
        return starCnt != null ? michelinKrEntity.starCnt.eq(starCnt) : null;
    } 

    // 레스토랑이름 체크 메서드
    private BooleanExpression equalFcltyNm(String fcltyNm){
        return fcltyNm != null ? michelinKrEntity.fcltyNm.eq(fcltyNm) : null;
    } 
    
    // 년도 체크 메서드
    private BooleanExpression equalYear(Integer year){
        return year != null ? michelinKrEntity.year.eq(year) : null;
    } 

    // 시도영문명 체크 메서드
    private BooleanExpression equalCtprvnEngNm(String ctprvnEngNm){
        return ctprvnEngNm != null ? michelinKrEntity.ctprvnEngNm.eq(ctprvnEngNm) : null;
    } 
}
