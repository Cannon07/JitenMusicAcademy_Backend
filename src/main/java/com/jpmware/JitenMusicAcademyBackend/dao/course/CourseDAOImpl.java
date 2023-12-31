package com.jpmware.JitenMusicAcademyBackend.dao.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpmware.JitenMusicAcademyBackend.entity.Class;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

@Repository
public class CourseDAOImpl implements CourseDAO {

    private EntityManager entityManager;

    @Autowired
    public CourseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Class createCourse(Class course) {
        entityManager.persist(course);
        return course;
    }

    @Override
    public Class getCourseById(int id) {
        return entityManager.find(Class.class, id);
    }

    @Override
    public List<Class> getAllClasses() {
        TypedQuery<Class> query = entityManager.createQuery("FROM Class", Class.class);
        return query.getResultList();
    }

    @Override
    public Class updateCourse(int id, Class course) {
        Class courseToBeUpdated = entityManager.find(Class.class, id);
        if (courseToBeUpdated == null) {
            return null;
        }
        entityManager.merge(course);
        return course;
    }

    @Override
    public Class deleteCourseById(int id) {
        Class course = entityManager.find(Class.class, id);
        if (course == null) {
            return null;
        }
        entityManager.remove(course);
        return course;
    }

    @Override
    public Class getCourseWithStudentsByCourseId(int id) {
        TypedQuery<Class> query = entityManager.createQuery(
            "SELECT c FROM Class c " + 
            "LEFT JOIN FETCH c.students " + 
            "WHERE c.id=:data", 
            Class.class
        );
        Class course = null;
        query.setParameter("data", id);
        try {
            course = query.getSingleResult();
        } catch (NoResultException exception) {

        }
        return course;
    }
    
}
