package com.api.michelinAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.michelinAPI.dto.paramDTO;
import com.api.michelinAPI.entity.ResultEntity;
import com.api.michelinAPI.dto.ResultDTO;
import com.api.michelinAPI.repository.ResultRepository;

@Service
public class ResultServiceImpl  implements ResultService{

    private final ResultRepository resultRepository;

    ResultServiceImpl(ResultRepository resultRepository){   
        this.resultRepository = resultRepository;
    }

    /**
     * 데이터 조회
     */
    @Override
    public List<ResultDTO> searchList(paramDTO paramdto) {
        
        List<ResultEntity> resultList = resultRepository.findMichelinList(paramdto);
        List<ResultDTO> dtoList = new ArrayList<>();

        for(int i = 0; i < resultList.size(); i++){
            ResultDTO dto = ResultDTO.toListDTO(resultList.get(i));
            dtoList.add(dto);
        }
    
        return dtoList;
    }
    
}
