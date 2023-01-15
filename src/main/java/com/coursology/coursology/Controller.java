package com.coursology.coursology;

import com.coursology.coursology.Entity.Course;
import com.coursology.coursology.Entity.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {
    @Autowired
    Service service;

    // Course End Points

    @PostMapping("/course")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        service.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllCourses());
    }

    @GetMapping("/courseByName/{name}")
    public ResponseEntity<Course> getCourseByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getCourseByName(name));
    }

    @GetMapping("/courseById/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getCourseById(id));
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course newCourse, @PathVariable int id) {
        newCourse.setId(id);
        service.updateCourse(newCourse, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(newCourse);
    }

    @DeleteMapping("/course/{id}")
    @Transactional
    public ResponseEntity<Void> deleteCourseById(@PathVariable int id) {
        service.deleteCourseById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Teacher End Points

    @PostMapping("/teacher")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        service.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(teacher);
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getTeachers() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllTeachers());
    }

    @GetMapping("/teacherById/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getTeacherById(id));
    }

    @GetMapping("/teachersBySubject/{subject}")
    public ResponseEntity<List<Teacher>> getTeacherByMainSubject(@PathVariable(required = true) String subject) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getTeacherBySubject(subject));
    }

    @PutMapping("/teacher/{id}")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher newTeacher, @PathVariable int id) {
        newTeacher.setId(id);
        service.updateTeacher(newTeacher, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(newTeacher);
    }

    @DeleteMapping("/teacher/{id}")
    @Transactional
    public ResponseEntity<Void> deleteTeacherById(@PathVariable int id) {
        service.deleteTeacherById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
