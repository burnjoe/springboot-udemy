package com.mojo.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    // Shows Add Todo Page
    // Having only the 'value' argument passed, it will handle both all HTTP methods (GET, POST, etc.)
    // e.g., @RequestMapping("add-todo")
    // Having the 'method' argument passed, it will handle only the specified HTTP method
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showAddTodoPage() {
        return "addTodo";
    }

    // Adds a Todo
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo() {
        // TODO: Do add todo logic here

        // Returning just this will only return the plain view, not the view with the model (ModelMap) containing the todos
        // return "listTodos";

        // Redirects to the '/list-todos'
        return "redirect:/list-todos";
    }
}
