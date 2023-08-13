package com.jpmware.JitenMusicAcademyBackend.service.student;

import java.util.List;

import com.jpmware.JitenMusicAcademyBackend.entity.Student;

public interface StudentService {
    
    // Create
    Student createStudent(Student student);

    // Read
    Student getStudentById(int id);
    List<Student> getAllStudents();

    // Update
    Student updateStudentById(int id, Student student);

    // Delete
    Student deleteStudentById(int id);
}
