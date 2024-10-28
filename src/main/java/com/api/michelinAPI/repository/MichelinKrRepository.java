package com.api.michelinAPI.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.michelinAPI.dto.paramDTO;
import com.api.michelinAPI.entity.MichelinKrEntity;

@Repository
public interface MichelinKrRepository {
    
    List<MichelinKrEntity> findMichelinList(paramDTO dto); // 미쉐린 대한민국 데이터 리스트

}
