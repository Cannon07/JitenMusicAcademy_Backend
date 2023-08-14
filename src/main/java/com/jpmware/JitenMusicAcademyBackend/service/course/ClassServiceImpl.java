package com.jpmware.JitenMusicAcademyBackend.service.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmware.JitenMusicAcademyBackend.dao.course.CourseDAO;
import com.jpmware.JitenMusicAcademyBackend.entity.Class;

import jakarta.transaction.Transactional;

@Service
public class ClassServiceImpl implements ClassService {
    
    private CourseDAO courseDAO;

    @Autowired
    public ClassServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
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
    
}
