package com.jpmware.JitenMusicAcademyBackend.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.jpmware.JitenMusicAcademyBackend.service.course.ClassService;

@RestController
@RequestMapping("/api/classes")
public class CourseController {

    private ClassService classService;

    @Autowired
    public CourseController(ClassService classService) {
        this.classService = classService;
    }

    // Post

    @PostMapping
    public Class createClass(@RequestBody Class course) {
        Class createdClass = classService.createClass(course);
        return createdClass;
    }

    @PostMapping("/{class_id}/enroll/{student_id}")
    public ResponseEntity<Map<String, String>> enrollStudentToCourse (@PathVariable int class_id, @PathVariable int student_id) {
        classService.enrollStudentToClass(class_id, student_id);
        Map <String, String> response = new TreeMap<>();
        String message = "Student with Student-ID " + student_id + 
            " has been successifully enrolled to the Class with Class-ID " + class_id;  
        response.put("message", message);
        return ResponseEntity.ok().body(response);
    }

    // Get

    @GetMapping("/{class_id}")
    public Class getClassById(@PathVariable int class_id) {
        Class course = classService.getClassById(class_id);
        return course;
    }
    
    @GetMapping
    public List<Class> getAllClasses() {
        List<Class> classes = classService.getAllClasses();
        return classes;
    }

    @GetMapping("/{class_id}/students")
    public List<Student> getStudentsEnrolledInClass(@PathVariable int class_id) {
        List<Student> students = classService.getStudentsInClass(class_id);
        return students;
    }

    // Update

    @PutMapping("/{class_id}")
    public Class updateClassById(@PathVariable int class_id, @RequestBody Class course) {
        Class updatedClass = classService.updateClass(class_id, course);
        return updatedClass;
    }

    // Delete

    @DeleteMapping("/{class_id}")
    public Class deleteClassById(@PathVariable int class_id) {
        Class deletedClass = classService.deleteClassById(class_id);
        return deletedClass;
    }
}
