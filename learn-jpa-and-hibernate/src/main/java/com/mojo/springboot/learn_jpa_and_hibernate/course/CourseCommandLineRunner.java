package com.mojo.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mojo.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

/*
 * This CommandLineRunner feature allows us to run code on application startup
 * 
 * CommandLineRunner is an interface provided by Spring Boot. 
 * It’s used to execute code after the Spring application has started. 
 * When the application context is initialized, the run() method in 
 * any CommandLineRunner bean is automatically invoked.
 */

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    // @Autowired
    // private CourseJdbcRepository repository;

    // @Autowired
    // private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    // This is executed at the startup of the Spring Boot application
    @Override
    public void run(String... args) throws Exception {
        // JDBC / JPA
        // repository.insert(new Course(1, "Learning AWS", "in28minutes"));
        // repository.insert(new Course(2, "Learning Azure", "in28minutes"));
        // repository.deleteById(1);
        // System.out.println(repository.findById(2));
        
        // Spring Data JPA
        repository.save(new Course(1, "Learning AWS", "in28minutes"));
        repository.save(new Course(2, "Learning Azure", "in28minutes"));
        repository.deleteById(1l);
        System.out.println(repository.findById(2l));
        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("in28minutes"));
    }
}
