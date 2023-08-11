package com.jpmware.JitenMusicAcademyBackend.dao.course;

import java.util.List;

import com.jpmware.JitenMusicAcademyBackend.entity.Class;

public interface CourseDAO {

    // Create
    void createCourse(Class course);

    // Read
    Class getCourseById(int id);
    List<Class> getAllClasses();
    Class getCourseWithStudentsByCourseId(int id);

    // Update
    void updateCourse(Class course);

    // Delete
    void deleteCourseById(int id);
}
