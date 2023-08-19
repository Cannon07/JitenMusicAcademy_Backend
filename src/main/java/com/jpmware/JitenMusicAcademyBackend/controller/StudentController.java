package com.jpmware.JitenMusicAcademyBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpmware.JitenMusicAcademyBackend.entity.Class;
import com.jpmware.JitenMusicAcademyBackend.entity.Student;
import com.jpmware.JitenMusicAcademyBackend.exception.custom.InvalidInputException;
import com.jpmware.JitenMusicAcademyBackend.service.student.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Post

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        return savedStudent;
    }

    // Get

    @GetMapping("/{student_id}")
    public Student getStudentById(@PathVariable String student_id) {
        try {
            int id = Integer.parseInt(student_id);
            Student student = studentService.getStudentById(id);
            return student;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Student ID: " + student_id);
        }
    }

    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students;
    }

    @GetMapping("/{student_id}/classes")
    public List<Class> getStudentEnrolledClasses(@PathVariable String student_id) {
        try {
            int id = Integer.parseInt(student_id);
            List<Class> classes = studentService.getStudentClasses(id);
            return classes;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Student ID: " + student_id);
        }
    }

    // Put

    @PutMapping("/{student_id}")
    public Student updatedStudent(@PathVariable String student_id, @RequestBody Student student) {
        try {
            int id = Integer.parseInt(student_id);
            Student updatedStudent = studentService.updateStudentById(id, student);
            return updatedStudent;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Student ID: " + student_id);
        }
    }

    // Delete

    @DeleteMapping("/{student_id}")
    public Student deleteStudent(@PathVariable String student_id) {
        try {
            int id = Integer.parseInt(student_id);
            Student deletedStudent = studentService.deleteStudentById(id);
            return deletedStudent;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Student ID: " + student_id);
        }
    }
}
