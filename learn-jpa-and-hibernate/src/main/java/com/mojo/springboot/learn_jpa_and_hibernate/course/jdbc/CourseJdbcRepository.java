package com.mojo.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mojo.springboot.learn_jpa_and_hibernate.course.Course;

// Indicates that this class is a Spring Data repository
@Repository
public class CourseJdbcRepository {

    // JdbcTemplate is used to interact with the database and execute SQL queries
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY = 
            """
                insert into course (id, name, author)
                    values (?, ?, ?);
            """;

    private static String DELETE_QUERY =
            """
                delete from course 
                where id = ?;
            """;

    // This method performs the insertion of the course into the database using the JdbcTemplate
    public void insert(Course course) {
        // This should be in sequence as in the INSERT_QUERY: (id, name, author)
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }

    // This method performs the deletion of the course from the database using the JdbcTemplate
    public void delete(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }
}
