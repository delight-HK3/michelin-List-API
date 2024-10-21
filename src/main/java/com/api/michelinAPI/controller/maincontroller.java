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
     * 대한민국 데이터요청
     * 
     * @param request
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/kr/michelin_list", method=RequestMethod.GET)
    public List<ResultDTO> michelinKrList(paramDTO paramdto) throws JsonProcessingException {

        if(paramdto.getRow() == null){
            new NullPointerException();
        }

        return resultService.searchKrList(paramdto);
    }
    
    /**
     * 일본 데이터요청
     * 
     * @param request
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/jp/michelin_list", method=RequestMethod.GET)
    public List<ResultDTO> michelinJpList(paramDTO paramdto) throws JsonProcessingException {

        if(paramdto.getRow() == null){
            new NullPointerException();
        }

        return resultService.searchJpList(paramdto);
    }
}
