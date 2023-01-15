package com.coursology.coursology;

import com.coursology.coursology.Entity.Course;
import com.coursology.coursology.Entity.Teacher;
import com.coursology.coursology.Exceptions.CourseNotFoundException;
import com.coursology.coursology.Exceptions.TeacherNotFoundException;
import com.coursology.coursology.Repository.CourseRepository;
import com.coursology.coursology.Repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(int id) {
        return courseRepository.getCourseById(id);
    }

    public Course getCourseByName(String name) {
        return courseRepository.getCourseByName(name);
    }

    public void updateCourse(Course newCourse, int id) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException("Course ID: " + id);
        }
        courseRepository.save(newCourse);
    }

    @Transactional
    public void deleteCourseById(int id) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException("Course ID: " + id);
        } else {
            courseRepository.deleteById(id);
        }

    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(int id) {
        return teacherRepository.getTeacherById(id);
    }

    public List<Teacher> getTeacherBySubject(String subject) {
        return teacherRepository.getTeacherBySubject(subject);
    }

    public void updateTeacher(Teacher newTeacher, int id) {
        if (!teacherRepository.existsById(id)) {
            throw new TeacherNotFoundException("Teacher ID: " + id);
        }
        teacherRepository.save(newTeacher);
    }

    public void deleteTeacherById(int id) {
        if (!teacherRepository.existsById(id)) {
            throw new TeacherNotFoundException("Teacher ID: " + id);
        }
        teacherRepository.deleteById(id);
    }
}
