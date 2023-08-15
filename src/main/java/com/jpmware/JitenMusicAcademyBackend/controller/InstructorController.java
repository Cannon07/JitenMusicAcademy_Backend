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
import com.jpmware.JitenMusicAcademyBackend.entity.Instructor;
import com.jpmware.JitenMusicAcademyBackend.service.instructor.InstructorService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    
    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    // Post

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        Instructor createdInstructor = instructorService.createInstructor(instructor);
        return createdInstructor;
    }

    // Get

    @GetMapping("/{instructor_id}")
    public Instructor getInstructorById(@PathVariable int instructor_id) {
        Instructor instructor = instructorService.getInstructorById(instructor_id);
        return instructor;
    }

    @GetMapping
    public List<Instructor> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        return instructors;
    }

    @GetMapping("/{instructor_id}/classes")
    public List<Class> getInstructorClasses(@PathVariable int instructor_id) {
        List<Class> classes = instructorService.getInstructorClasses(instructor_id);
        return classes;
    }

    // Put

    @PutMapping("/{instructor_id}")
    public Instructor updateInstructorById(@PathVariable int instructor_id, @RequestBody Instructor instructor) {
        Instructor updatedInstructor = instructorService.updateInstructorById(instructor_id, instructor);
        return updatedInstructor;
    }

    // Delete

    @DeleteMapping("/{instructor_id}")
    public Instructor deleteInstructorById(@PathVariable int instructor_id) {
        Instructor deletedInstructor = instructorService.deleteInstructorById(instructor_id);
        return deletedInstructor;
    }

}
