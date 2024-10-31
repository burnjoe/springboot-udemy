package com.mojo.learn_spring_framework.examples.h1;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mojo.learn_spring_framework.game.GameRunner;

public class XmlConfigurationContextLauncherApplication {

    public static void main(String[] args) {
        // Using the XML Configuration so we don't need a @ComponentScan and @Configuration in this particular class
        try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            // This prints out the bean names available in context: contextConfiguration.xml
            Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

            // This prints out the value of the bean with the id/name: "name" and "age"
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));

            // This runs the bean defined named "gameRunner" in contextConfiguration
            context.getBean(GameRunner.class).run();
        }
    }
}
