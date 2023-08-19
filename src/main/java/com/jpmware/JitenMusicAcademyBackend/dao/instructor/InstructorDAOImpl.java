package com.jpmware.JitenMusicAcademyBackend.dao.instructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpmware.JitenMusicAcademyBackend.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

@Repository
public class InstructorDAOImpl implements InstructorDAO{

    private EntityManager entityManager;

    @Autowired
    public InstructorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Instructor createInstructor(Instructor instructor) {        
        entityManager.persist(instructor);
        return instructor;
    }

    @Override
    public Instructor getInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        TypedQuery<Instructor> query = entityManager.createQuery("FROM Instructor", Instructor.class);
        List<Instructor> instructors = query.getResultList();
        return instructors;
    }

    @Override
    public Instructor updateInstructor(int id, Instructor instructor) {
        Instructor instructorToBeUpdated = entityManager.find(Instructor.class, id);
        if (instructorToBeUpdated == null) {
            return null;
        }
        entityManager.merge(instructor);
        return instructor;
    }

    @Override
    public Instructor deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        if (instructor == null) {
            return null;
        }
        entityManager.remove(instructor);
        return instructor;
    }

    @Override
    public Instructor getInstructorWithClassesByInstructorId(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
            "SELECT i FROM Instructor i " + 
            "LEFT JOIN FETCH i.classes " +
            "WHERE i.id=:data", 
            Instructor.class
        );
        query.setParameter("data", id);
        Instructor instructor = null;
        try {
            instructor = query.getSingleResult();
        } catch (NoResultException exception) {

        }
        return instructor;
    }
    
}
