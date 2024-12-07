package com.mojo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    
    private static List<Todo> todos = new ArrayList<>();

    // Static Block
    // A special block of code in Java that is used to initialize static variables 
    static {
        todos.add(new Todo(1, "mojo", "Learn AWS", 
                LocalDate.now().plusMonths(1), false));
        todos.add(new Todo(2, "mojo", "Learn DevOps", 
                LocalDate.now().plusMonths(2), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }
}
