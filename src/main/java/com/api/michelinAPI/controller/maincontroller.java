package com.api.michelinAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.api.michelinAPI.dto.paramDTO;
import com.api.michelinAPI.dto.ResultDTO;
import com.api.michelinAPI.service.ResultService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class maincontroller {

    private final ResultService resultService;

    maincontroller(ResultService resultService){
        this.resultService = resultService;
    }

    /**
     * api guide page
     * 
     * @param mav
     * @return
     */
    @RequestMapping(value="/",  method = RequestMethod.GET)
    public ModelAndView main(ModelAndView mav) {
        
        mav.setViewName("/index");

        return mav;
    }
    
    /**
     * api 요청
     * 
     * @param request
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/api/michelin_list", method=RequestMethod.GET)
    public List<ResultDTO> requestMethodName(paramDTO paramdto) throws JsonProcessingException {

        if(paramdto.getCountryNm().equals(null) || paramdto.getRow() == null){
            new NullPointerException();
        }

        return resultService.searchList(paramdto);
    }
    
}
