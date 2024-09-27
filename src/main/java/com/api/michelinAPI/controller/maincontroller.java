package com.api.michelinAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class maincontroller {

    @GetMapping("/")
    public String main() {

        return "index";
    }
    
    @ResponseBody
    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String requestMethodName(HttpServletRequest request) {
        return "API test";
    }
    
}
