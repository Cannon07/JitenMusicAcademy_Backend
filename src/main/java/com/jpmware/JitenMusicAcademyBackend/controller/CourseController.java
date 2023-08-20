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
import com.jpmware.JitenMusicAcademyBackend.entity.Instructor;
import com.jpmware.JitenMusicAcademyBackend.entity.Student;
import com.jpmware.JitenMusicAcademyBackend.exception.custom.InvalidInputException;
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
    public ResponseEntity<Map<String, String>> enrollStudentToCourse (
            @PathVariable String class_id, 
            @PathVariable String student_id
        ) {
        
        // Checking if the passed IDs are valid or not
        
        int valid_class_id = -1;
        int valid_student_id = -1;
        try {
            valid_class_id = Integer.parseInt(class_id);
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Class ID: " + class_id);
        }
        try {
            valid_student_id = Integer.parseInt(student_id);
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Student ID: " + student_id);
        }

        // Enrolling Student to the Class

        classService.enrollStudentToClass(valid_class_id, valid_student_id);

        // Creating an appropriate Response

        Map <String, String> response = new TreeMap<>();
        String message = "Student with Student-ID " + student_id + 
            " has been successfully enrolled to the Class with Class-ID " + class_id;  
        response.put("message", message);

        // Sending the response

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/{class_id}/unenroll/{student_id}")
    public ResponseEntity<Map<String, String>> unenrollStudentFromCourse (
            @PathVariable String class_id, 
            @PathVariable String student_id
        ) {
        
        // Checking if the passed IDs are valid or not
        
        int valid_class_id = -1;
        int valid_student_id = -1;
        try {
            valid_class_id = Integer.parseInt(class_id);
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Class ID: " + class_id);
        }
        try {
            valid_student_id = Integer.parseInt(student_id);
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Student ID: " + student_id);
        }

        // Unenrolling Student from Class

        classService.unenrollStudentFromClass(valid_class_id, valid_student_id);

        // Creating an appropriate Response

        Map <String, String> response = new TreeMap<>();
        String message = "Student with Student-ID " + student_id + 
            " has been successfully unenrolled from the Class with Class-ID " + class_id;  
        response.put("message", message);

        // Sending the response

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/{class_id}/assign-instructor/{instructor_id}")
    public ResponseEntity<Map<String, String>> assignInstructorToCourse (
            @PathVariable String class_id, 
            @PathVariable String instructor_id
        ) {
        int valid_class_id = -1;
        int valid_instructor_id = -1;
        try {
            valid_class_id = Integer.parseInt(class_id);
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Class ID: " + class_id);
        }
        try {
            valid_instructor_id = Integer.parseInt(instructor_id);
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Instructor ID: " + instructor_id);
        }
        classService.assignInstructorToCourse(valid_class_id, valid_instructor_id);
        Map <String, String> response = new TreeMap<>();
        String message = "Instructor with Instructor-ID " + instructor_id + 
            " has been successfully assigned to the Class with Class-ID " + class_id;  
        response.put("message", message);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/{class_id}/dismiss-instructor/{instructor_id}")
    public ResponseEntity<Map<String, String>> dismissInstructorFromCourse (
            @PathVariable String class_id, 
            @PathVariable String instructor_id
        ) {
        int valid_class_id = -1;
        int valid_instructor_id = -1;
        try {
            valid_class_id = Integer.parseInt(class_id);
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Class ID: " + class_id);
        }
        try {
            valid_instructor_id = Integer.parseInt(instructor_id);
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Instructor ID: " + instructor_id);
        }
        classService.dismissInstructorFromCourse(valid_class_id, valid_instructor_id);
        Map <String, String> response = new TreeMap<>();
        String message = "Instructor with Instructor-ID " + instructor_id + 
            " has been successfully dismissed from the Class with Class-ID " + class_id;  
        response.put("message", message);
        return ResponseEntity.ok().body(response);
    }

    // Get

    @GetMapping("/{class_id}")
    public Class getClassById(@PathVariable String class_id) {
        try {
            int id = Integer.parseInt(class_id);
            Class course = classService.getClassById(id);
            return course;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Class ID: " + class_id);
        }
    }
    
    @GetMapping
    public List<Class> getAllClasses() {
        List<Class> classes = classService.getAllClasses();
        return classes;
    }

    @GetMapping("/{class_id}/students")
    public List<Student> getStudentsEnrolledInClass(@PathVariable String class_id) {
        try {
            int id = Integer.parseInt(class_id);
            List<Student> students = classService.getStudentsInClass(id);
            return students;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Class ID: " + class_id);
        }
    }

    @GetMapping("/{class_id}/instructor")
    public Instructor getClassInstructor(@PathVariable String class_id) {
        try { 
            int id = Integer.parseInt(class_id);
            Instructor instructor = classService.getClassInstructor(id);
            return instructor;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Class ID: " + class_id);
        }
    }

    // Update

    @PutMapping("/{class_id}")
    public Class updateClassById(@PathVariable String class_id, @RequestBody Class course) {
        try {
            int id = Integer.parseInt(class_id);
            Class updatedClass = classService.updateClass(id, course);
            return updatedClass;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Class ID: " + class_id);
        }
    }

    // Delete

    @DeleteMapping("/{class_id}")
    public Class deleteClassById(@PathVariable String class_id) {
        try {
            int id = Integer.parseInt(class_id);
            Class deletedClass = classService.deleteClassById(id);
            return deletedClass;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Class ID: " + class_id);
        }
    }
}
