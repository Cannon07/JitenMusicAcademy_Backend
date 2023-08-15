package com.jpmware.JitenMusicAcademyBackend.service.instructor;

import java.util.List;

import com.jpmware.JitenMusicAcademyBackend.entity.Instructor;
import com.jpmware.JitenMusicAcademyBackend.entity.Class;

public interface InstructorService {

    // Create
    Instructor createInstructor(Instructor instructor);
    
    // Read
    Instructor getInstructorById(int id);
    List<Instructor> getAllInstructors();
    List<Class> getInstructorClasses(int id);

    // Update
    Instructor updateInstructorById(int id, Instructor instructor);

    // Delete
    Instructor deleteInstructorById(int id);

}
