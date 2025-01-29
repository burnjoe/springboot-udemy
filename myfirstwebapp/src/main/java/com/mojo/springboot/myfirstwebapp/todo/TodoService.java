package com.mojo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    // Deletes a Todo
    public void deleteTodoById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);

        // removeIf() method removes all elements of this collection that satisfy the given predicate
        // The predicate is a lambda expression that returns a boolean value (See Lambda Functions and Functional Programming)
        // Shorter version of predicate usage
        // todos.removeIf(todo -> todo.getId() == id);
    }

    // Finds a Todo by id
    public Todo findById(int id) {
        // stream() method returns a sequential Stream with this collection as its source
        // See Functional Programming and Stream API for more information
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .get();
    }
}
