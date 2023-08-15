package com.jpmware.JitenMusicAcademyBackend.service.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmware.JitenMusicAcademyBackend.dao.course.CourseDAO;
import com.jpmware.JitenMusicAcademyBackend.dao.instructor.InstructorDAO;
import com.jpmware.JitenMusicAcademyBackend.dao.student.StudentDAO;
import com.jpmware.JitenMusicAcademyBackend.entity.Class;
import com.jpmware.JitenMusicAcademyBackend.entity.Instructor;
import com.jpmware.JitenMusicAcademyBackend.entity.Student;

import jakarta.transaction.Transactional;

@Service
public class ClassServiceImpl implements ClassService {
    
    private CourseDAO courseDAO;
    private StudentDAO studentDAO;
    private InstructorDAO instructorDAO;

    @Autowired
    public ClassServiceImpl(CourseDAO courseDAO, StudentDAO studentDAO, InstructorDAO instructorDAO) {
        this.courseDAO = courseDAO;
        this.studentDAO = studentDAO;
        this.instructorDAO = instructorDAO;
    }

    @Override
    public List<Class> getAllClasses() {
        return courseDAO.getAllClasses();
    }
    
    @Override
    public Class getClassById(int id) {
        Class course = courseDAO.getCourseById(id);
        return course;
    }

    @Override
    @Transactional
    public Class createClass(Class course) {
        Class createdClass = courseDAO.createCourse(course);
        return createdClass;
    }

    @Override
    @Transactional
    public Class updateClass(int id, Class course) {
        Class updatedClass = courseDAO.updateCourse(course);
        return updatedClass;
    }

    @Override
    @Transactional
    public Class deleteClassById(int id) {
        Class deletedClass = courseDAO.deleteCourseById(id);
        return deletedClass;
    }

    @Override
    public List<Student> getStudentsInClass(int id) {
        Class course = courseDAO.getCourseWithStudentsByCourseId(id);
        List<Student> students = course.getStudents();
        return students;
    }

    @Override
    public Instructor getClassInstructor(int id) {
        Class course = courseDAO.getCourseById(id);
        Instructor instructor = course.getInstructor();
        return instructor;
    }

    @Override
    @Transactional
    public void enrollStudentToClass(int class_id, int student_id) {
        Class course = courseDAO.getCourseWithStudentsByCourseId(class_id);
        Student student = studentDAO.getStudentById(student_id);
        course.addStudent(student);
        courseDAO.updateCourse(course);
    }

    @Override
    @Transactional
    public void assignInstructorToCourse(int class_id, int instructor_id) {
        Class course = courseDAO.getCourseById(class_id);
        Instructor instructor = instructorDAO.getInstructorById(instructor_id);
        course.setInstructor(instructor);
        courseDAO.updateCourse(course);
    }
    
}
