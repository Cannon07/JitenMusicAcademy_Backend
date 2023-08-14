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

import com.jpmware.JitenMusicAcademyBackend.entity.Student;
import com.jpmware.JitenMusicAcademyBackend.service.student.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        return savedStudent;
    }

    @GetMapping("/{student_id}")
    public Student getStudentById(@PathVariable int student_id) {
        Student student = studentService.getStudentById(student_id);
        return student;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students;
    }

    @PutMapping("/{student_id}")
    public Student updatedStudent(@PathVariable int student_id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudentById(student_id, student);
        return updatedStudent;
    }

    @DeleteMapping("/{student_id}")
    public Student deleteStudent(@PathVariable int student_id) {
        Student deletedStudent = studentService.deleteStudentById(student_id);
        return deletedStudent;
    }
}
