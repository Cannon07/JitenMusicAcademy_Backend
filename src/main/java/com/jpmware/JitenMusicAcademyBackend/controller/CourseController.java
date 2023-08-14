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
import com.jpmware.JitenMusicAcademyBackend.service.course.ClassService;

@RestController
@RequestMapping("/api/classes")
public class CourseController {

    private ClassService classService;

    @Autowired
    public CourseController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public Class createClass(@RequestBody Class course) {
        Class createdClass = classService.createClass(course);
        return createdClass;
    }

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

    @PutMapping("/{class_id}")
    public Class updateClassById(@PathVariable int class_id, @RequestBody Class course) {
        Class updatedClass = classService.updateClass(class_id, course);
        return updatedClass;
    }

    @DeleteMapping("/{class_id}")
    public Class deleteClassById(@PathVariable int class_id) {
        Class deletedClass = classService.deleteClassById(class_id);
        return deletedClass;
    }
}
