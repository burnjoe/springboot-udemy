package com.mojo.springboot.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


// Indicates that this class handles HTTP requests and returns responses directly as JSON or XML
@RestController
public class CourseController {
    
    // Handles requests to "/courses"
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                    new Course(1, "Learn Springboot", "in28minutes"),
                    new Course(2, "Learn DevOps", "in28minutes"),
                    new Course(3, "Learn AWS", "in28minutes")
                );
    }
}
