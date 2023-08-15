package com.jpmware.JitenMusicAcademyBackend.service.instructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmware.JitenMusicAcademyBackend.dao.instructor.InstructorDAO;
import com.jpmware.JitenMusicAcademyBackend.entity.Class;
import com.jpmware.JitenMusicAcademyBackend.entity.Instructor;

import jakarta.transaction.Transactional;

@Service
public class InstructorServiceImpl implements InstructorService{
    
    private InstructorDAO instructorDAO;

    @Autowired
    public InstructorServiceImpl (InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Override
    @Transactional
    public Instructor createInstructor(Instructor instructor) {
        Instructor createdInstructor = instructorDAO.createInstructor(instructor);
        return createdInstructor;
    }

    @Override
    public Instructor getInstructorById(int id) {
        Instructor instructor = instructorDAO.getInstructorById(id);
        return instructor;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        List<Instructor> instructors = instructorDAO.getAllInstructors();
        return instructors;
    }

    @Override
    public List<Class> getInstructorClasses(int id) {
        Instructor instructor = instructorDAO.getInstructorWithClassesByInstructorId(id);
        List<Class> classes = instructor.getClasses();
        return classes;
    }

    @Override
    @Transactional
    public Instructor updateInstructorById(int id, Instructor instructor) {
        Instructor updatedInstructor = instructorDAO.updateInstructor(instructor);
        return updatedInstructor;
    }

    @Override
    @Transactional
    public Instructor deleteInstructorById(int id) {
        Instructor deletedInstructor = instructorDAO.deleteInstructorById(id);
        return deletedInstructor;
    }
    
}
