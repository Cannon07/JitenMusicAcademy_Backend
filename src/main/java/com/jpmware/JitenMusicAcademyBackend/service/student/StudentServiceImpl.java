package com.jpmware.JitenMusicAcademyBackend.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmware.JitenMusicAcademyBackend.dao.student.StudentDAO;
import com.jpmware.JitenMusicAcademyBackend.entity.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = studentDAO.getStudentById(id);
        return student;
    }

    @Override
    @Transactional
    public Student createStudent(Student student) {
        Student savedStudent = studentDAO.createStudent(student);
        return savedStudent;
    }

    @Override
    @Transactional
    public Student updateStudentById(int id, Student student) {
        Student updatedStudent = studentDAO.updateStudent(student);
        return updatedStudent;
    }

    @Override
    @Transactional
    public Student deleteStudentById(int id) {
        Student deletedStudent = studentDAO.deleteStudentById(id);
        return deletedStudent;
    }
    
}
