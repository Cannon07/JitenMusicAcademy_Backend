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
import com.jpmware.JitenMusicAcademyBackend.exception.custom.InvalidInputException;
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
    public Instructor getInstructorById(@PathVariable String instructor_id) {
        try {
            int id = Integer.parseInt(instructor_id);
            Instructor instructor = instructorService.getInstructorById(id);
            return instructor;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Instructor ID: " + instructor_id);
        }
        
    }

    @GetMapping
    public List<Instructor> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        return instructors;
    }

    @GetMapping("/{instructor_id}/classes")
    public List<Class> getInstructorClasses(@PathVariable String instructor_id) {
        try {
            int id = Integer.parseInt(instructor_id);
            List<Class> classes = instructorService.getInstructorClasses(id);
            return classes; 
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Instructor ID: " + instructor_id);
        }
    }

    // Put

    @PutMapping("/{instructor_id}")
    public Instructor updateInstructorById(@PathVariable String instructor_id, @RequestBody Instructor instructor) {
        try {
            int id = Integer.parseInt(instructor_id);
            Instructor updatedInstructor = instructorService.updateInstructorById(id, instructor);
            return updatedInstructor;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Instructor ID: " + instructor_id);
        }
    }

    // Delete

    @DeleteMapping("/{instructor_id}")
    public Instructor deleteInstructorById(@PathVariable String instructor_id) {
        try {
            int id = Integer.parseInt(instructor_id);
            Instructor deletedInstructor = instructorService.deleteInstructorById(id);
            return deletedInstructor;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid Instructor ID: " + instructor_id);
        }
    }

}
