package com.absoft.limitsservice.controllers;

import com.absoft.limitsservice.bean.Limit;
import com.absoft.limitsservice.configuration.LimitsConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    
    @Autowired
    private LimitsConfiguration limitsConfig;
    
    @GetMapping(path="/limits")
    public Limit getLimits(){
        return new Limit(limitsConfig.getMinimum(),limitsConfig.getMaximum());
    }
}
