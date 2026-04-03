package com.mojo.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    
    // Simulate database (Use Spring JPA/Hibernate)
    private static List<User> users = new ArrayList<>();
    
    // Simulate auto-incrementing ID
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Joe", LocalDate.now().minusYears(10)));
        users.add(new User(++usersCount, "Jane", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount, "John", LocalDate.now().minusYears(30)));
    }

    // Returns all users
    public List<User> findAll() {
        return users;
    }

    // Returns user by id
    public User findById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;

        // Using stream to find user by id
        // Or just put the predicate directly in the filter without a variable for brevity
        return users.stream()
                    .filter(predicate)
                    .findFirst()
                    .get();
    }

    // Inserts a new user
    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
