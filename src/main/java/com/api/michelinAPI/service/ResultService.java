package com.api.michelinAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.michelinAPI.dto.paramDTO;
import com.api.michelinAPI.entity.MichelinJpEntity;
import com.api.michelinAPI.entity.MichelinKrEntity;
import com.api.michelinAPI.exception.NoDataException;
import com.api.michelinAPI.repository.MichelinJpRepository;
import com.api.michelinAPI.repository.MichelinKrRepository;
import com.api.michelinAPI.dto.ResultDTO;

@Service
public class ResultService{

    private final MichelinKrRepository michelinKrRepository;
    private final MichelinJpRepository michelinJpRepository;

    ResultService(MichelinKrRepository michelinKrRepository, MichelinJpRepository michelinJpRepository){   
        this.michelinKrRepository = michelinKrRepository;
        this.michelinJpRepository = michelinJpRepository;
    }

    /**
     * 대한민국 데이터 조회
     */
    public List<ResultDTO> searchKrList(paramDTO paramdto) {
        List<ResultDTO> dtoList = new ArrayList<>();
        List<MichelinKrEntity> resultList = michelinKrRepository.findMichelinList(paramdto);
        if(resultList.size() == 0){ throw new NoDataException(); }
            
        for(int i = 0; i < resultList.size(); i++){
            ResultDTO dto = ResultDTO.toListKrDTO(resultList.get(i));
            dtoList.add(dto);
        }

        return dtoList;
    }
    
    /**
     * 일본 데이터 조회
     */
    public List<ResultDTO> searchJpList(paramDTO paramdto) {

        List<ResultDTO> dtoList = new ArrayList<>();
        List<MichelinJpEntity> resultList = michelinJpRepository.findMichelinList(paramdto);
        if(resultList.size() == 0){ throw new NoDataException(); }
            
        for(int i = 0; i < resultList.size(); i++){
            ResultDTO dto = ResultDTO.toListJpDTO(resultList.get(i));
            dtoList.add(dto);
        }

        return dtoList;
    }
}
