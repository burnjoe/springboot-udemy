package com.mojo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

/*
 * Two-way binding:
 * - The first side is when we set the model attribute in the controller method to be binded in the jsp form
 * - The second side is when we bind the form data to the method parameter in the controller method upon form submission
 */

@Controller
public class TodoControllerJpa {
    
    private TodoRepository todoRepository;

    // Autowires it implicitly
    public TodoControllerJpa(TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
    }

    // List Todos
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        // String username = (String) model.get("name");
        String username = getLoggedInUsername(model);

        // TODO: Allow to get the username from the session
        List<Todo> todos = todoRepository.findByUsername(username);
        
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
        // This is to bind the Todo object to the form in addEditTodo.jsp
        // This is the first side of the two-way binding (Whatever is set in the ModelMap model will be displayed in the form)
        // Which is the created Todo object with the default values
        // String username = (String) model.get("name");

        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0, username, "", 
                LocalDate.now().plusDays(7), false);
        model.put("todo", todo);
        return "addEditTodo";
    }

    // Adds a Todo
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    // @RequestParam is used to bind the form data to the method parameter
    // Instead of using @RequestParam for number of attributes required, we can use the Todo model (called as form backing object) as parameter to bind the form data
    // Note that the ModelMap would be the first parameter in the method signature
    // This is the second side of the two-way binding (Whatever is submitted in the form will be binded in the Todo object)
    // @Valid is used to validate the Todo object based on the validation rules set in the Todo class
    // BindingResult is used to get the validation result
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        // If there are validation errors, return the addEditTodo page
        if (result.hasErrors()) {
            return "addEditTodo";
        }
        
        // String username = (String) model.get("name");
        String username = getLoggedInUsername(model);

        // Setting the username in the Todo object to be saved in the database using the repository
        todo.setUsername(username);
        todoRepository.save(todo);

        // Returning just this will only return the plain view, not the view with the model (ModelMap) containing the todos
        // return "listTodos";

        // Redirects to the '/list-todos'
        // return "redirect:/list-todos"; or
        return "redirect:list-todos";
    }

    // Deletes a Todo
    @RequestMapping("delete-todo")
    // The 'id' query parameter is binded to the 'id' method parameter /delete-todo?id=N (where N is the id)
    public String deleteTodo(@RequestParam int id) {   
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    // Shows Edit Todo Page
    @RequestMapping(value = "edit-todo", method = RequestMethod.GET)
    public String showEditTodoPage(@RequestParam int id, ModelMap model) {
        // The findById() method returns an Optional<Todo> object from the repository, so we need to call get() to get the Todo object
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "addEditTodo";
    }

    // Updates a Todo
    @RequestMapping(value = "edit-todo", method = RequestMethod.POST)
    public String editTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        // If there are validation errors, return the addEditTodo page
        if (result.hasErrors()) {
            return "addEditTodo";
        }

        // String username = (String) model.get("name");
        String username = getLoggedInUsername(model);
        todo.setUsername(username);

        // Setting the username in the Todo object to be saved in the database using the repository
        todoRepository.save(todo);

        return "redirect:list-todos";
    }

    // Gets the logged in username
    private String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        return authentication.getName();
    }
}
