package com.mojo.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<entity, primary key>
@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    // Other field names other than id must be explicitly defined: findBy<fieldName> (fieldName == column name)
    public List<Todo> findByUsername(String username);
}
