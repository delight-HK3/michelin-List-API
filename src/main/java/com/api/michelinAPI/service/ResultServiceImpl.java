package com.api.michelinAPI.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.michelinAPI.dto.paramDTO;
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
        
        String tableYear = String.valueOf(paramdto.getYear()).equals("null") ? "2024" : String.valueOf(paramdto.getYear());
        String tableNm = "michelin_List_"+tableYear;

        System.out.println("========================");
        System.out.println(tableNm);
        System.out.println("========================");

        List<ResultDTO> result = null;
        //List<resultDTO> result = resultRepository.result(tableNm);

        return result;
    }
    
}
