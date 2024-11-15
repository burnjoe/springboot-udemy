package com.mojo.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mojo.springboot.learn_jpa_and_hibernate.course.Course;

// This extends the JpaRepository<Type, Id> to simplify JPA even more with JpaRepository's methods
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    
}
