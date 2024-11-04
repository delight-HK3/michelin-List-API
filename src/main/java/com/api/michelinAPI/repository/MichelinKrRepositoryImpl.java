package com.api.michelinAPI.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.michelinAPI.dto.paramDTO;
import com.api.michelinAPI.entity.MichelinKrEntity;
import com.api.michelinAPI.entity.QMichelinKrEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class MichelinKrRepositoryImpl implements MichelinKrRepository{
    
    // QueryDSL
    private final JPAQueryFactory queryFactory;
    
    // JPQL
    @PersistenceContext // 영속성 컨텍스트 Bean 주입
    private final EntityManager em;

    MichelinKrRepositoryImpl(JPAQueryFactory queryFactory, EntityManager em){   
        this.queryFactory = queryFactory;
        this.em = em;
    }

    // QMichelinKrEntity 등록
    QMichelinKrEntity michelinKrEntity = QMichelinKrEntity.michelinKrEntity;
    
    // QueryDSL 방식
    @Override
    public List<MichelinKrEntity> findMichelinList(paramDTO dto){
        return queryFactory.from(michelinKrEntity) 
                            .select(michelinKrEntity)
                            .where(
                                equalStarCnt(dto.getStarCnt())
                                , equalFcltyNm(dto.getFcltyNm())
                                , equalCtprvnEngNm(dto.getCtprvnEngNm())
                                , equalSustainAbility(dto.getSustainAbility())
                            )
                            .limit(dto.getRow())
                            .fetch(); 
    }

    // 별개수 체크 메서드 QueryDSL
    private BooleanExpression equalStarCnt(Integer starCnt){
        return starCnt != null ? michelinKrEntity.starCnt.eq(starCnt) : null;
    } 

    // 레스토랑이름 체크 메서드 QueryDSL
    private BooleanExpression equalFcltyNm(String fcltyNm){
        return fcltyNm != null ? michelinKrEntity.fcltyNm.eq(fcltyNm) : null;
    } 

    // 시도영문명 체크 메서드 QueryDSL
    private BooleanExpression equalCtprvnEngNm(String ctprvnEngNm){
        return ctprvnEngNm != null ? michelinKrEntity.ctprvnEngNm.eq(ctprvnEngNm) : null;
    } 

    // 년도 체크 메서드 QueryDSL
    private BooleanExpression equalYear(Integer year) {
        return year != null ? michelinKrEntity.year.eq(year) : null;
    }

    // 지속가능성 체크 메서드 QueryDSL
    private BooleanExpression equalSustainAbility(Integer sustainAbility) {
        return sustainAbility != null ? michelinKrEntity.sustainability.eq(sustainAbility) : null;
    }

    // JPQL 방식
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<MichelinKrEntity> findMichelinKrList(paramDTO dto) {
        String tableNm = dto.getYear() != null ? "michelin_list_kr_"+dto.getYear() : "michelin_list_kr";
        
        String query = "SELECT SEQ, MICHELIN_NM, FCLTY_NM, RDNMADR_NM, CTPRVN_ENG_NM,"
                              + "FCLTY_LO, FCLTY_LA, STAR_CNT, EVALUATION_YEAR, FOOD_CATG, SUSTAINABILITY"
                              + " FROM " + tableNm
                              + " WHERE 1=1" 
                              + equalStarCntNative(dto.getStarCnt()) 
                              + equalFcltyNmNative(dto.getFcltyNm())
                              + equalCtprvnEngNmNative(dto.getCtprvnEngNm())
                              + equalYearNative(dto.getYear())
                              + equalSustainAbilityNative(dto.getSustainAbility())
                              + " LIMIT " + dto.getRow();

        List<MichelinKrEntity> result = em.createNativeQuery(query, MichelinKrEntity.class).getResultList();

        return result;
    }

    // 별개수 체크 메서드 네이티브
    private String equalStarCntNative(Integer starCnt){
        return starCnt != null ? " AND STAR_CNT = "+starCnt : "";
    }

    // 레스토랑이름 체크 메서드 네이티브
    private String equalFcltyNmNative(String fcltyNm){
        return fcltyNm != null ? " AND FCLTY_NM = "+fcltyNm : "";
    } 

    // 시도영문명 체크 메서드 네이티브
    private String equalCtprvnEngNmNative(String ctprvnEngNm){
        return ctprvnEngNm != null ? " AND CTPRVN_ENG_NM = "+ctprvnEngNm : "";
    }
    
    // 년도 체크 메서드 네이티브
    private String equalYearNative(Integer year) {
        return year != null ? " AND EVALUATION_YEAR = "+year : "";
    }

    // 지속가능성 체크 메서드 네이티브
    private String equalSustainAbilityNative(Integer sustainAbility) {
        return sustainAbility != null ? " AND SUSTAINABILITY = "+sustainAbility : "";
    }
}
