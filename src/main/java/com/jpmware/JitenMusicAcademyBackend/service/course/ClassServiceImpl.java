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
import com.jpmware.JitenMusicAcademyBackend.exception.custom.ClassNotFoundException;
import com.jpmware.JitenMusicAcademyBackend.exception.custom.InstructorAssignmentException;
import com.jpmware.JitenMusicAcademyBackend.exception.custom.InstructorNotFoundException;
import com.jpmware.JitenMusicAcademyBackend.exception.custom.StudentEnrollmentException;
import com.jpmware.JitenMusicAcademyBackend.exception.custom.StudentNotFoundException;

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
        if (course == null) {
            throw new ClassNotFoundException(id);
        }
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
        Class updatedClass = courseDAO.updateCourse(id, course);
        if (updatedClass == null) {
            throw new ClassNotFoundException(id);
        }
        return updatedClass;
    }

    @Override
    @Transactional
    public Class deleteClassById(int id) {
        Class deletedClass = courseDAO.deleteCourseById(id);
        if (deletedClass == null) {
            throw new ClassNotFoundException(id);
        }
        return deletedClass;
    }

    @Override
    public List<Student> getStudentsInClass(int id) {
        Class course = courseDAO.getCourseWithStudentsByCourseId(id);
        if (course == null) {
            throw new ClassNotFoundException(id);
        }
        List<Student> students = course.getStudents();
        return students;
    }

    @Override
    public Instructor getClassInstructor(int id) {
        Class course = courseDAO.getCourseById(id);
        if (course == null) {
            throw new ClassNotFoundException(id);
        }
        Instructor instructor = course.getInstructor();
        return instructor;
    }

    @Override
    @Transactional
    public void enrollStudentToClass(int class_id, int student_id) {
        Class course = courseDAO.getCourseWithStudentsByCourseId(class_id);
        if (course == null) {
            throw new ClassNotFoundException(class_id);
        }
        Student student = studentDAO.getStudentById(student_id);
        if (student == null) {
            throw new StudentNotFoundException(student_id);
        }
        List<Student> enrolledStudents = course.getStudents();
        if (enrolledStudents.contains(student)) {
            throw new StudentEnrollmentException(
                "Student with ID " + student_id + " is already enrolled in the Class with ID " + class_id
            );
        }
        course.addStudent(student);
        courseDAO.updateCourse(class_id, course);
    }

    @Override
    @Transactional
    public void unenrollStudentFromClass(int class_id, int student_id) {
        Class course = courseDAO.getCourseWithStudentsByCourseId(class_id);
        if (course == null) {
            throw new ClassNotFoundException(class_id);
        }
        Student student = studentDAO.getStudentById(student_id);
        if (student == null) {
            throw new StudentNotFoundException(student_id);
        }
        List<Student> enrolledStudents = course.getStudents();
        if (!enrolledStudents.contains(student)) {
            throw new StudentEnrollmentException(
                "Student with ID " + student_id + " is not enrolled in the Class with ID " + class_id
            );
        }
        course.removeStudent(student);
        courseDAO.updateCourse(class_id, course);
    }

    @Override
    @Transactional
    public void assignInstructorToCourse(int class_id, int instructor_id) {
        Class course = courseDAO.getCourseById(class_id);
        if (course == null) {
            throw new ClassNotFoundException(class_id);
        }
        Instructor instructor = instructorDAO.getInstructorById(instructor_id);
        if (instructor == null) {
            throw new InstructorNotFoundException(instructor_id);
        }
        if (course.getInstructor() != null) {
            throw new InstructorAssignmentException(
                "Class with ID " + class_id + " already has an assigned Instructor"
            );
        } 
        course.setInstructor(instructor);
        courseDAO.updateCourse(class_id, course);
    }

    @Override
    @Transactional
    public void dismissInstructorFromCourse(int class_id, int instructor_id) {
        Class course = courseDAO.getCourseById(class_id);
        if (course == null) {
            throw new ClassNotFoundException(class_id);
        }
        Instructor instructor = instructorDAO.getInstructorById(instructor_id);
        if (instructor == null) {
            throw new InstructorNotFoundException(instructor_id);
        }
        if (course.getInstructor() == null) {
            throw new InstructorAssignmentException(
                "Class with ID " + class_id + " has no assigned Instructor"
            );
        } 
        course.setInstructor(null);
        courseDAO.updateCourse(class_id, course);
    }
    
}
