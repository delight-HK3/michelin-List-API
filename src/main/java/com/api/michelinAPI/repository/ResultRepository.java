package com.api.michelinAPI.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.michelinAPI.dto.paramDTO;
import com.api.michelinAPI.entity.QResultEntity;
import com.api.michelinAPI.entity.ResultEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ResultRepository{
    
    // QueryDSL
    private final JPAQueryFactory queryFactory;
    
    // JPQL
    //private final EntityManager em;
    
    //@Query(value="select * from :tableNm where EVALUATION_YEAR = :#{#dto.year}",nativeQuery = true)
    //List<ResultEntity> searchListBy(@Param("dto") paramDTO dto, String tableNm);

    public List<ResultEntity> findMichelinList(paramDTO dto){
        QResultEntity resultEntity = QResultEntity.resultEntity; 
        List<ResultEntity> result = queryFactory.from(resultEntity)
                                    .select(resultEntity)
                                    .where(resultEntity.starCnt.eq(dto.getStarCnt()))
                                    .fetch();

        return result;
    }

}
