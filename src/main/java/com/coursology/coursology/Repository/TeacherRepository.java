package com.coursology.coursology.Repository;

import com.coursology.coursology.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher getTeacherById(int id);

    List<Teacher> getTeacherBySubject(String subject);
}
