package com.jpmware.JitenMusicAcademyBackend.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmware.JitenMusicAcademyBackend.dao.student.StudentDAO;
import com.jpmware.JitenMusicAcademyBackend.entity.Student;
import com.jpmware.JitenMusicAcademyBackend.exception.custom.StudentNotFoundException;
import com.jpmware.JitenMusicAcademyBackend.entity.Class;

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
        if (student == null) {
            throw new StudentNotFoundException(id);
        }
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
        Student updatedStudent = studentDAO.updateStudent(id, student);
        if (updatedStudent == null) {
            throw new StudentNotFoundException(id);
        }
        return updatedStudent;
    }

    @Override
    @Transactional
    public Student deleteStudentById(int id) {
        Student deletedStudent = studentDAO.deleteStudentById(id);
        if (deletedStudent == null) {
            throw new StudentNotFoundException(id);
        }
        return deletedStudent;
    }

    @Override
    public List<Class> getStudentClasses(int id) {
        Student student = studentDAO.getStudentWithCoursesByStudentId(id);
        if (student == null) {
            throw new StudentNotFoundException(id);
        }
        List<Class> classes = student.getClasses();
        return classes;
    }
    
    
}
