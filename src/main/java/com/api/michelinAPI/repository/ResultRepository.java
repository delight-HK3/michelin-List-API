package com.api.michelinAPI.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.michelinAPI.dto.paramDTO;
import com.api.michelinAPI.entity.QResultEntity;
import com.api.michelinAPI.entity.ResultEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ResultRepository{
    
    // QueryDSL
    private final JPAQueryFactory queryFactory;
    private final QResultEntity resultEntity;

    // JPQL
    //private final EntityManager em;
    
    //@Query(value="select * from :tableNm where EVALUATION_YEAR = :#{#dto.year}",nativeQuery = true)
    //List<ResultEntity> searchListBy(@Param("dto") paramDTO dto, String tableNm);

    public List<ResultEntity> findMichelinList(paramDTO dto){
        return queryFactory.from(resultEntity) 
                            .select(resultEntity)
                            .where(
                                allSearch(dto)
                            )
                            .fetch();
    }

    // 별개수 지정 메서드
    private BooleanExpression equalStarCnt(paramDTO dto){
        return dto.getStarCnt() != null ? resultEntity.starCnt.eq(dto.getStarCnt()) : null;
    }

    // 전체 검색조건
    private BooleanExpression allSearch(paramDTO dto){
        return equalStarCnt(dto);
    }
    
}
