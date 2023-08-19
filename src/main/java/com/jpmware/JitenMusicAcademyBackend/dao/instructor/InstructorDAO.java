package com.jpmware.JitenMusicAcademyBackend.dao.instructor;

import java.util.List;

import com.jpmware.JitenMusicAcademyBackend.entity.Instructor;

public interface InstructorDAO {
    
    // Create
    Instructor createInstructor(Instructor instructor);

    // Read
    Instructor getInstructorById(int id);
    List<Instructor> getAllInstructors();
    Instructor getInstructorWithClassesByInstructorId(int id);

    // Update
    Instructor updateInstructor(int id, Instructor instructor);

    // Delete
    Instructor deleteInstructorById(int id);
    
}
