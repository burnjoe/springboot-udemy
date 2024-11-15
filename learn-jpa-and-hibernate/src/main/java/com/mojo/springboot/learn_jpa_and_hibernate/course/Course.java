package com.mojo.springboot.learn_jpa_and_hibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Marks this class as a JPA entity to be mapped to a database table
// The usage of MongoDB suggests to use @Document instead of @Entity since it's for relational db / JPA
// @Entity(name = "Course_Details") -> explicitly defining table name
@Entity
public class Course {

    // Marks this field as primary key (PK)
    @Id
    private long id;

    // Explicitly maps this field to the 'name' column in db table
    @Column(name = "name")
    private String name;
    
    // You can implicitly map this field to 'author' column in db table since it has the same field name (Default)
    private String author;


    public Course() {}

    public Course(long id, String name, String author) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
    }
}
