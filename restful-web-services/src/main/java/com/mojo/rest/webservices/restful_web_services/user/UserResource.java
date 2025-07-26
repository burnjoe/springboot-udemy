package com.mojo.rest.webservices.restful_web_services.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    
    private UserDaoService userDaoService;


    // Constructor injection for UserDaoService
    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    // GET: /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    // GET: /user/{id}
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return userDaoService.findById(id);
    }
}
