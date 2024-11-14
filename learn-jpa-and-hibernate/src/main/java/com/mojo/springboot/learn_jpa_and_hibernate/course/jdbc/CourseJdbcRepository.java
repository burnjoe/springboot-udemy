package com.mojo.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Indicates that this class is a Spring Data repository
@Repository
public class CourseJdbcRepository {

    // JdbcTemplate is used to interact with the database and execute SQL queries
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY = 
            """
                insert into course (id, name, author)
                    values (1, 'Learn AWS', 'in28minutes');
            """;

    // This method performs the insertion of the course into the database using the JdbcTemplate
    public void insert() {
        springJdbcTemplate.update(INSERT_QUERY);
    }
}
