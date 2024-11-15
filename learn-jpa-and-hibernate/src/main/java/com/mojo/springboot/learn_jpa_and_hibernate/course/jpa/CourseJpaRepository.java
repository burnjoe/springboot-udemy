package com.mojo.springboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.mojo.springboot.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
// Marks the class for transaction management, ensuring operations are committed or rolled back automatically (Marked all methods as Transactional)
@Transactional
public class CourseJpaRepository {
    
    // @Autowired - does work but not recommended
    // Injects the EntityManager for JPA operations with transaction management
    // This allows automatic handling of transactions and session contexts
    @PersistenceContext
    private EntityManager entityManager;

    // Inserts Course entity with JPA
    public void insert(Course course) {
        // Inserts the given Course entity in the database
        // Or update if the Course entity already exists
        // This already maps the Course entity to database's Course entity
        entityManager.merge(course);
    }

    // Retrieve and finds Course enteity with JPA
    public Course findById(long id) {
        // Finds the Course given the id
        return entityManager.find(Course.class, id);
    }
    
    // Deletes Course entity with JPA
    public void deleteById(long id) {
        // Finds the Course given the id and deletes it
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
