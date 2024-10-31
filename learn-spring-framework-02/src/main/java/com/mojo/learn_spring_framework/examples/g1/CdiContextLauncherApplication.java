package com.mojo.learn_spring_framework.examples.g1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

/*
 * CDI annotations is the alternative of Spring annotations
 * CDI is a specification (interface) and Spring Framework implements it 
 * CDI              Spring Framework
 * @Inject      ==  @Autowired
 * @Named       ==  @Component
 * @Qualifier   ==  @Qualifier
 * @Scope       ==  @Scope
 * @Singleton   ==  @Singleton
 */

// @Component
@Named
class BusinessService {

    private DataService dataService;
    
    // @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }
}

// @Component
@Named
class DataService {}


@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {
            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
