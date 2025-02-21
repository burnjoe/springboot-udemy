package com.mojo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

// Bean --Maps-to--> Database Table
// e.g., Todo class --> Todo table
// Classes annotated with @Entity means that this bean maps to a database table (think of a Model in an MVC framework)
// Spring Boot auto-configuration: if it sees a class annotated with @Entity, it will create an h2 table for that class automatically
// This class will be mapped to a table called "TodoTable"
// @Entity(name = "TodoTable")
@Entity
public class Todo {
    
    // @Id annotation means that this field is the primary key
    // @GeneratedValue generates the primary key with a sequence
    @Id
    @GeneratedValue
    private int id;

    // This field will be mapped to a column called "user_name"
    // @Column(name = "user_name")
    private String username;

    // Validation rule for the description field
    // Requiring @Valid annotation in the controller method parameter to validate the Todo object
    @Size(min = 10, message = "Enter at least 10 characters.")
    private String description;
    private LocalDate targetDate;
    private boolean done;


    // Default Constructor
    public Todo() {
        super();
    }


    // Constructor
    public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
        super();
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    // toString method
    @Override
    public String toString() {
        return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
                + targetDate + ", done=" + done + "]";
    }
}
