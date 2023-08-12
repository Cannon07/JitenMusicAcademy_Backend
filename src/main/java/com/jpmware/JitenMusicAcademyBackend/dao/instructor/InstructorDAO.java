package com.jpmware.JitenMusicAcademyBackend.dao.instructor;

import java.util.List;

import com.jpmware.JitenMusicAcademyBackend.entity.Instructor;

public interface InstructorDAO {
    
    // Create
    void createInstructor(Instructor instructor);

    // Read
    Instructor getInstructorById(int id);
    List<Instructor> getAllInstructors();

    // Update
    void updateInstructor(Instructor instructor);

    // Delete
    void deleteInstructorById(int id);
}
