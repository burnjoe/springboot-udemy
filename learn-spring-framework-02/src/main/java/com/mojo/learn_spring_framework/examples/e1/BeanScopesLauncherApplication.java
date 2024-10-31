package com.mojo.learn_spring_framework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * Singleton - one object instance per Spring IoC container
 * Prototype - possibly many object instances per Spring IoC container
 */

// NormalClass has a scope Singleton by default - no need to explicitly annotate the class as Singleton
// @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
class NormalClass {}

// PrototypeClass has a scope Prototype - explicitly annotating the class as Prototype with @Scope
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {}


@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {
            // This would return the same instance of the NormalClass everytime you get this bean - Singleton
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            
            // This would return different instances of the PrototypeClass everytime you get its bean - Prototype
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
        }
    }
}
