package com.coursology.coursology;

import com.coursology.coursology.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class Controller {
    @Autowired
    Service service;

    @PostMapping("/course")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        service.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses(@RequestParam(required = false) String courseName) {
        if(courseName != null) {
            return ResponseEntity.status(HttpStatus.OK).body(service.getCourseByCourseName(courseName));
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllCourses());
    }
}
