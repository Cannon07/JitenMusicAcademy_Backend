package com.jpmware.JitenMusicAcademyBackend.service.course;

import java.util.List;

import com.jpmware.JitenMusicAcademyBackend.entity.Class;
import com.jpmware.JitenMusicAcademyBackend.entity.Instructor;
import com.jpmware.JitenMusicAcademyBackend.entity.Student;

public interface ClassService {

    // Create
    Class createClass(Class course);
    void enrollStudentToClass(int class_id, int student_id);
    void unenrollStudentFromClass(int class_id, int student_id);
    void assignInstructorToCourse(int class_id, int instructor_id);
    
    // Read
    Class getClassById(int id);
    List<Class> getAllClasses();
    List<Student> getStudentsInClass(int id);
    Instructor getClassInstructor(int id);

    // Update
    Class updateClass(int id, Class course);

    // Delete
    Class deleteClassById(int id);

}
