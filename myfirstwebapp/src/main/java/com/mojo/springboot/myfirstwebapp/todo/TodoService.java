package com.mojo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    
    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    // Static Block
    // A special block of code in Java that is used to initialize static variables 
    static {
        todos.add(new Todo(++todosCount, "mojo", "Learn AWS", 
                LocalDate.now().plusMonths(1), false));
        todos.add(new Todo(++todosCount, "mojo", "Learn DevOps", 
                LocalDate.now().plusMonths(2), false));
    }

    // Finds all Todos by username
    public List<Todo> findByUsername(String username) {
        return todos;
    }

    // Adds a Todo
    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }
}
