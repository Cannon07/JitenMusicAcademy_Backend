package com.jpmware.JitenMusicAcademyBackend.service.instructor;

import java.util.List;

import com.jpmware.JitenMusicAcademyBackend.entity.Instructor;

public interface InstructorService {

    // Create
    Instructor createInstructor(Instructor instructor);
    
    // Read
    Instructor getInstructorById(int id);
    List<Instructor> getAllInstructors();

    // Update
    Instructor updateInstructorById(int id, Instructor instructor);

    // Delete
    Instructor deleteInstructorById(int id);

}
