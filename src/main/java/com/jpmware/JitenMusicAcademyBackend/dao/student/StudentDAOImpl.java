package com.jpmware.JitenMusicAcademyBackend.dao.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpmware.JitenMusicAcademyBackend.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student createStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student getStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public Student updateStudent(int id, Student student) {
        Student studentToBeUpdated = entityManager.find(Student.class, id);
        if (studentToBeUpdated == null) {
            return null;
        }
        entityManager.merge(student);
        return student;
    }

    @Override
    public Student deleteStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        if (student == null) {
            return null;
        }
        entityManager.remove(student);
        return student;
    }

    @Override
    public Student getStudentWithCoursesByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery(
            "SELECT s FROM Student s " + 
            "LEFT JOIN FETCH s.classes " +
            "WHERE s.id=:data", 
            Student.class
        );
        query.setParameter("data", id);
        Student student = null;
        try {
            student = query.getSingleResult();
        } catch (NoResultException exception) {

        }
        return student;
    }
    
}
