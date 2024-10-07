package com.api.michelinAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.michelinAPI.dto.paramDTO;
import com.api.michelinAPI.entity.ResultEntity;

@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Integer>{
    
    @Query(value="",nativeQuery = true)
    List<ResultEntity> searchListBy();

}
