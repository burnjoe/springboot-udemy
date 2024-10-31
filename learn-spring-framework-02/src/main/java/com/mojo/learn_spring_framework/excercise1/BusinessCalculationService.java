package com.mojo.learn_spring_framework.excercise1;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// @Component
@Service
public class BusinessCalculationService {
    
    private DataService dataService;

    // Constructor injection - uses the bean/component marked with @Primary
    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }
    
    public int findMax() {
        return Arrays.stream(dataService.retrieveData())
                .max()
                .orElse(0);
    }
}
