package com.mojo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        // TODO: Allow to get the username from the session
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
    public String showAddTodoPage(ModelMap model) {
        // This is to bind the Todo object to the form in addTodo.jsp
        String username = (String) model.get("name");
        Todo todo = new Todo(0, username, "", 
                LocalDate.now().plusDays(7), false);
        model.put("todo", todo);
        return "addTodo";
    }

    // Adds a Todo
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    // @RequestParam is used to bind the form data to the method parameter
    // Instead of using @RequestParam for number of attributes required, we can use the Todo model (called as form backing object) as parameter to bind the form data
    // Note that the ModelMap would be the first parameter in the method signature
    public String addTodo(ModelMap model, Todo todo) {
        // TODO: Allow to provide desired target date
        String username = (String) model.get("name");
        todoService.addTodo(username, todo.getDescription(), 
                LocalDate.now().plusDays(7), false);

        // Returning just this will only return the plain view, not the view with the model (ModelMap) containing the todos
        // return "listTodos";

        // Redirects to the '/list-todos'
        return "redirect:/list-todos";
    }
}
