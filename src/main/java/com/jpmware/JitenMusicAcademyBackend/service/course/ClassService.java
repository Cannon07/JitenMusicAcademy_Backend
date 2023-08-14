package com.jpmware.JitenMusicAcademyBackend.service.course;

import java.util.List;

import com.jpmware.JitenMusicAcademyBackend.entity.Class;

public interface ClassService {

    // Create
    Class createClass(Class course);
    
    // Read
    Class getClassById(int id);
    List<Class> getAllClasses();

    // Update
    Class updateClass(int id, Class course);

    // Delete
    Class deleteClassById(int id);

}
