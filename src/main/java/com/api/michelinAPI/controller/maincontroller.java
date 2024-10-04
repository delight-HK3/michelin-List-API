package com.api.michelinAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.api.michelinAPI.dto.paramDTO;

@RestController
public class maincontroller {



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
     */
    @RequestMapping(value="/api/michelin_list", method=RequestMethod.GET)
    public String requestMethodName(paramDTO paramdto) throws Exception{

        System.out.println(paramdto);

        return "API test";
    }
    
}
