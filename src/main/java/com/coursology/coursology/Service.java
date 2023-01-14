package com.coursology.coursology;

import com.coursology.coursology.Entity.Course;
import com.coursology.coursology.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    CourseRepository courseRepository;
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public List<Course> getCourseByCourseName(String courseName) {
        return courseRepository.getCourseByName(courseName);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
