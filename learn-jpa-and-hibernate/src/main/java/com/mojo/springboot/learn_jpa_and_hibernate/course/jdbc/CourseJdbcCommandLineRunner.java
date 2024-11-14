package com.mojo.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mojo.springboot.learn_jpa_and_hibernate.course.Course;

/*
 * This CommandLineRunner feature allows us to run code on application startup
 * 
 * CommandLineRunner is an interface provided by Spring Boot. 
 * It’s used to execute code after the Spring application has started. 
 * When the application context is initialized, the run() method in 
 * any CommandLineRunner bean is automatically invoked.
 */

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    // This is executed at the startup of the Spring Boot application
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learning AWS", "in28minutes"));
        repository.insert(new Course(2, "Learning Azure", "in28minutes"));

        repository.delete(1);
    }
}
