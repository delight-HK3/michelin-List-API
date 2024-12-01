package com.api.michelinAPI.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.michelinAPI.dto.paramDTO;
import com.api.michelinAPI.entity.MichelinJpEntity;
import static com.api.michelinAPI.entity.QMichelinJpEntity.michelinJpEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

@Repository
public class MichelinJpRepositoryImpl implements MichelinJpRepository{
    
    // QueryDSL
    private final JPAQueryFactory queryFactory;
    
    // native SQL
    private final EntityManager em;

    MichelinJpRepositoryImpl(JPAQueryFactory queryFactory, EntityManager em){   
        this.queryFactory = queryFactory;
        this.em = em;
    }
    
    // QueryDSL 방식
    @Override
    public List<MichelinJpEntity> findMichelinList(paramDTO dto){
        return queryFactory.from(michelinJpEntity) 
                            .select(michelinJpEntity)
                            .where(
                                equalStarCnt(dto.getStarcnt())
                                , equalFcltyNm(dto.getFcltynm())
                                , equalCtprvnEngNm(dto.getCtprvnengnm())
                                , equalSustainAbility(dto.getSustainability())
                            )
                            .limit(dto.getRow())
                            .fetch(); 
    }
    
    // 별개수 체크 메서드 QueryDSL
    private BooleanExpression equalStarCnt(Integer starCnt){
        return starCnt != null ? michelinJpEntity.starCnt.eq(starCnt) : null;
    } 

    // 레스토랑이름 체크 메서드 QueryDSL
    private BooleanExpression equalFcltyNm(String fcltyNm){
        return fcltyNm != null ? michelinJpEntity.fcltyNm.eq(fcltyNm) : null;
    } 

    // 시도영문명 체크 메서드 QueryDSL
    private BooleanExpression equalCtprvnEngNm(String ctprvnEngNm){
        return ctprvnEngNm != null ? michelinJpEntity.ctprvnEngNm.eq(ctprvnEngNm) : null;
    }
    
    // 년도 체크 메서드 QueryDSL
    private BooleanExpression equalYear(Integer year) {
        return year != null ? michelinJpEntity.year.eq(year) : null;
    }

    // 지속가능성 체크 메서드 QueryDSL
    private BooleanExpression equalSustainAbility(Integer sustainAbility) {
        return sustainAbility != null ? michelinJpEntity.sustainability.eq(sustainAbility) : null;
    }

    // JPQL 방식
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<MichelinJpEntity> findMichelinJpList(paramDTO dto) {

        String tableNm = dto.getYear() != null ? "michelin_list_jp_"+dto.getYear() : "michelin_list_jp";
    
        String query = "SELECT SEQ, MICHELIN_NM, FCLTY_NM, RDNMADR_NM, CTPRVN_ENG_NM,"
                              + "FCLTY_LO, FCLTY_LA, STAR_CNT, EVALUATION_YEAR, FOOD_CATG, SUSTAINABILITY"
                              + " FROM " + tableNm
                              + " WHERE 1=1" 
                              + equalStarCntNative(dto.getStarcnt()) 
                              + equalFcltyNmNative(dto.getFcltynm())
                              + equalCtprvnEngNmNative(dto.getCtprvnengnm())
                              + equalSustainAbilityNative(dto.getSustainability())
                              + limitRowNative(dto.getRow());

        List<MichelinJpEntity> result = em.createNativeQuery(query, MichelinJpEntity.class).getResultList();

        return result;
    }

    // 별개수 체크 메서드 네이티브
    private String equalStarCntNative(Integer starCnt){
        return starCnt != null ? " AND STAR_CNT = "+starCnt : "";
    }

    // 레스토랑이름 체크 메서드 네이티브
    private String equalFcltyNmNative(String fcltyNm){
        return fcltyNm != null ? " AND FCLTY_NM = "+"\'"+ fcltyNm +"\'" : "";
    } 

    // 시도영문명 체크 메서드 네이티브
    private String equalCtprvnEngNmNative(String ctprvnEngNm){
        return ctprvnEngNm != null ? " AND CTPRVN_ENG_NM = "+"\'"+ctprvnEngNm +"\'" : "";
    }

    // 지속가능성 체크 메서드 네이티브
    private String equalSustainAbilityNative(Integer sustainAbility) {
        return sustainAbility != null ? " AND SUSTAINABILITY = "+sustainAbility : "";
    }

    // 최대 출력 ROW 메서드
    private String limitRowNative(Integer row){
        return row != null ? " LIMIT " + row : "";
    }
}
