package com.mojo.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    // Autowires it implicitly
    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    // List Todos
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("mojo");
        
        // Similar to model.put() but model.addAttribute() is the recommended way
        model.addAttribute("todos", todos);
        
        return "listTodos";
    }
}
