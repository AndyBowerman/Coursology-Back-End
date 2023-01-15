package com.coursology.coursology.Exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String target) {
        super(target + " not found");
    }
}
