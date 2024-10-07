package com.api.michelinAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.michelinAPI.dto.paramDTO;
import com.api.michelinAPI.dto.ResultDTO;

@Service
public interface ResultService {
    
    List<ResultDTO> searchList(paramDTO paramdto);

}
