package com.jpmware.JitenMusicAcademyBackend.dao.student;

import java.util.List;

import com.jpmware.JitenMusicAcademyBackend.entity.Student;

public interface StudentDAO {

    // create
    void createStudent(Student student);

    // read
    Student getStudentById(int id);
    List<Student> getAllStudents();
    Student getStudentWithCoursesByStudentId(int id);

    // update
    void updateStudent(Student student);

    // delete
    void deleteStudentById(int id);

}
