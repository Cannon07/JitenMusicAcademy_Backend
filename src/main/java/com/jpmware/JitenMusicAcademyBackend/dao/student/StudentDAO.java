package com.jpmware.JitenMusicAcademyBackend.dao.student;

import java.util.List;

import com.jpmware.JitenMusicAcademyBackend.entity.Student;

public interface StudentDAO {

    // create
    Student createStudent(Student student);

    // read
    Student getStudentById(int id);
    List<Student> getAllStudents();
    Student getStudentWithCoursesByStudentId(int id);

    // update
    Student updateStudent(int id, Student student);

    // delete
    Student deleteStudentById(int id);

}
