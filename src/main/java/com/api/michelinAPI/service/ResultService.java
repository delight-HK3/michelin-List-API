package com.api.michelinAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.michelinAPI.dto.ResultDTO;
import com.api.michelinAPI.dto.paramDTO;

@Service
public interface ResultService {

    List<ResultDTO> searchKrList(paramDTO paramdto); // 미쉐린 대한민국 데이터 리스트

    List<ResultDTO> searchJpList(paramDTO paramdto); // 미쉐린 일본 데이터 리스트
}