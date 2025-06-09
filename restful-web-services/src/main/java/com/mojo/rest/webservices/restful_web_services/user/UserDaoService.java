package com.mojo.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    
    // Simulate database (Use Spring JPA/Hibernate)
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Joe", LocalDate.now().minusYears(10)));
        users.add(new User(2, "Jane", LocalDate.now().minusYears(20)));
        users.add(new User(3, "John", LocalDate.now().minusYears(30)));
    }

    // Returns all users
    public List<User> findAll() {
        return users;
    }

    // TODO: public User save(User user) {}

    // TODO: public User findOne(int id) {}
}
