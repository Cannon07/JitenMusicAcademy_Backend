package com.jpmware.JitenMusicAcademyBackend.dao.course;

import java.util.List;

import com.jpmware.JitenMusicAcademyBackend.entity.Class;

public interface CourseDAO {

    // Create
    Class createCourse(Class course);

    // Read
    Class getCourseById(int id);
    List<Class> getAllClasses();
    Class getCourseWithStudentsByCourseId(int id);

    // Update
    Class updateCourse(Class course);

    // Delete
    Class deleteCourseById(int id);
}
