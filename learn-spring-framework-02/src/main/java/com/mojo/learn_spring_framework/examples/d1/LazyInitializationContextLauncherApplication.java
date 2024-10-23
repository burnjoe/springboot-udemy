package com.mojo.learn_spring_framework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {}

/*
 * Default initialization for Spring Beans: Eager
 * 
 * @Lazy defers the initialization of a bean until it is actually needed
 * ClassB will be initialized upon calling it
 * 
 * Recommended: Eager initialization
 */
@Component
@Lazy
class ClassB {

    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("Some initialization logic");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Do something");
    }
}


@Configuration
@ComponentScan
public class LazyInitializationContextLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyInitializationContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

            // ClassB will get initialized at this point, since it's called and needed - it's not yet initialized upon app launch or startup
            context.getBean(ClassB.class).doSomething();
        }
    }
}
