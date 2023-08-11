package com.jpmware.JitenMusicAcademyBackend;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpmware.JitenMusicAcademyBackend.dao.course.CourseDAO;
import com.jpmware.JitenMusicAcademyBackend.dao.student.StudentDAO;
import com.jpmware.JitenMusicAcademyBackend.entity.Class;
import com.jpmware.JitenMusicAcademyBackend.entity.Student;

@SpringBootApplication
public class JitenMusicAcademyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JitenMusicAcademyBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (CourseDAO courseDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// findStudentById(studentDAO);
			// showAllStudents(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudentById(studentDAO);
			// createCourse(courseDAO);
			// findCourseById(courseDAO);
			// getAllCourses(courseDAO);
			// updateCourse(courseDAO);
			// deleteCourseById(courseDAO);
		};
	}

	private void deleteCourseById(CourseDAO courseDAO) {
		int course_id = 2;
		courseDAO.deleteCourseById(course_id);
	}

	private void updateCourse(CourseDAO courseDAO) {
		int course_id = 1;
		Class course = courseDAO.getCourseById(course_id);
		course.setDescription("Indian Classical");
		courseDAO.updateCourse(course);
	}

	private void getAllCourses(CourseDAO courseDAO) {
		List<Class> courses = courseDAO.getAllClasses();
		System.out.println(courses);
	}

	private void findCourseById(CourseDAO courseDAO) {
		int course_id = 1;
		Class course = courseDAO.getCourseById(course_id);
		System.out.println(course);
	}

	private void createCourse(CourseDAO courseDAO) {
		Class course = new Class("Tabla", "Indian Classical");
		courseDAO.createCourse(course);
	}

	private void deleteStudentById(StudentDAO studentDAO) {
		int student_id = 1;
		studentDAO.deleteStudentById(student_id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int student_id = 1;
		Student student = studentDAO.getStudentById(student_id);
		student.setPhone(1111111111);
		studentDAO.updateStudent(student);
	}

	private void showAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.getAllStudents();
		System.out.println(students);
	}

	private void findStudentById(StudentDAO studentDAO) {
		int student_id = 1;
		Student student = studentDAO.getStudentById(student_id);
		System.out.println(student);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Mohana", "mohana@email.com", 1234567890, null);
		studentDAO.createStudent(student);
	}

}
