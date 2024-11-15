package com.mojo.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mojo.springboot.learn_jpa_and_hibernate.course.Course;

// This extends the JpaRepository<Type, Id> to simplify JPA even more with JpaRepository's methods
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    
    /*
     * Or you can define your own custom method
     * Naming Conventions: findBy[fieldName]
     * Prefixes: findBy
     * Examples: findByAuthor(String author);
     */

    List<Course> findByName(String name);
    
    List<Course> findByAuthor(String author);

}
