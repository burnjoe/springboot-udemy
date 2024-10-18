package com.mojo.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person(String name, int age, Address address) {};
record Address(String firstLine, String city) {};

// Configure the Spring Beans
@Configuration
public class HelloWorldConfiguration {

    // A Bean that will be managed by the spring context
    @Bean
    public String name() {
        return "Joe";
    }

    @Bean
    public int age() {
        return 22;
    }

    @Bean
    public Person person() {
        return new Person("Lawrence", 22, new Address("Main Street", "London"));
    }

    // Approach 1: Calls bean method directly
    // @Primary tells the context that this bean is priority when getBean(Person.class) is called,
    // given that there are multiple candidates of the Person bean, which throws exception if @Primary is undefined
    @Bean
    @Primary
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }
    
    // Approach 2: Fields are passed as argument in method's parameters automatically with Auto Wiring
    // Calls the beans with names: name, age, myAddress
    @Bean
    public Person person3Parameters(String name, int age, Address myAddress) {
        return new Person(name, age, myAddress);
    }

    // Utilizes @Qualifier to specify which bean to inject
    @Bean
    public Person person4Parameters(String name, int age, @Qualifier("address2qualifier") Address address) {
        return new Person(name, age, address);
    }

    // This creates a bean with custom bean name "myAddress" than "address"
    @Bean(name = "myAddress")
    public Address address() {
        return new Address("Halang", "Calamba");
    }

    // @Qualifier is used to resolve ambiguity when multiple beans of the same type are available for dependency injection
    // This provides a name or identifier to which bean should be injected during autowiring
    // If there are multiple matching beans are available you can either use @Primary or @Qualifier
    @Bean(name = "myAddress2")
    @Qualifier("address2qualifier")
    public Address address2() {
        return new Address("San Isidro", "Cabuyao");
    }
}
