package com.coursology.coursology.Exceptions;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(String target) {
        super(target + " not found");
    }
}
