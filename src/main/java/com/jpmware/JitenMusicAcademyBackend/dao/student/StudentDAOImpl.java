package com.jpmware.JitenMusicAcademyBackend.dao.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpmware.JitenMusicAcademyBackend.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createStudent(Student student) {
        entityManager.persist(student);
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
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
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
