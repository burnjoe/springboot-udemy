package com.mojo.learn_spring_framework.excercise1;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {
    
    DataService dataService;

    // Constructor injection - uses the bean/component marked with @Primary
    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }
    
    public int findMax() {
        return Arrays.stream(dataService.retrieveData())
                .max()
                .orElse(0);
    }
}
