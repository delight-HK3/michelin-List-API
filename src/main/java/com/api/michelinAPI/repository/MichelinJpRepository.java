package com.api.michelinAPI.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.michelinAPI.dto.paramDTO;
import com.api.michelinAPI.entity.MichelinJpEntity;

@Repository
public interface MichelinJpRepository {

    List<MichelinJpEntity> findMichelinList(paramDTO dto); // 미쉐린 일본 데이터 리스트 (QueryDSL)

    List<MichelinJpEntity> findMichelinJpList(paramDTO dto); // 미쉐린 일본 데이터 리스트 (JPQL)
}
