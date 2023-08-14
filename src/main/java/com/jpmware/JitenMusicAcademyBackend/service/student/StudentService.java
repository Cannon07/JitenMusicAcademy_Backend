package com.jpmware.JitenMusicAcademyBackend.service.student;

import java.util.List;

import com.jpmware.JitenMusicAcademyBackend.entity.Student;
import com.jpmware.JitenMusicAcademyBackend.entity.Class;

public interface StudentService {
    
    // Create
    Student createStudent(Student student);

    // Read
    Student getStudentById(int id);
    List<Student> getAllStudents();
    List<Class> getStudentClasses(int id);

    // Update
    Student updateStudentById(int id, Student student);

    // Delete
    Student deleteStudentById(int id);
}
