package com.api.michelinAPI.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.michelinAPI.dto.paramDTO;
import com.api.michelinAPI.entity.MichelinJpEntity;
import com.api.michelinAPI.entity.MichelinKrEntity;
import com.api.michelinAPI.exception.NoDataException;
import com.api.michelinAPI.repository.MichelinJpRepositoryImpl;
import com.api.michelinAPI.repository.MichelinKrRepositoryImpl;

import com.api.michelinAPI.dto.ResultDTO;

@Service
public class ResultServiceImpl implements ResultService{

    private final MichelinKrRepositoryImpl michelinKrRepository;
    private final MichelinJpRepositoryImpl michelinJpRepository;

    ResultServiceImpl(MichelinKrRepositoryImpl michelinKrRepository, MichelinJpRepositoryImpl michelinJpRepository){   
        this.michelinKrRepository = michelinKrRepository;
        this.michelinJpRepository = michelinJpRepository;
    }

    /**
     * 미쉐린 대한민국 데이터 리스트
     */
    @Override
    public List<ResultDTO> searchKrList(paramDTO paramdto) {
        List<ResultDTO> dtoList = new ArrayList<>();
        //List<MichelinKrEntity> resultList = michelinKrRepository.findMichelinList(paramdto);
        List<MichelinKrEntity> resultList = michelinKrRepository.findMichelinKrList(paramdto);

        if(resultList.size() == 0){ throw new NoDataException(); }

        for(int i = 0; i < resultList.size(); i++){
            ResultDTO dto = ResultDTO.toListKrDTO(resultList.get(i));
            dtoList.add(dto);
        }

        return dtoList;

    }

    /**
     * 미쉐린 일본 데이터 리스트
     */
    @Override
    public List<ResultDTO> searchJpList(paramDTO paramdto) {
        List<ResultDTO> dtoList = new ArrayList<>();
        //List<MichelinJpEntity> resultList = michelinJpRepository.findMichelinList(paramdto);
        List<MichelinJpEntity> resultList = michelinJpRepository.findMichelinJpList(paramdto);

        if(resultList.size() == 0){ throw new NoDataException(); }
        
        for(int i = 0; i < resultList.size(); i++){
            ResultDTO dto = ResultDTO.toListJpDTO(resultList.get(i));
            dtoList.add(dto);
        }

        return dtoList;
    }

}
