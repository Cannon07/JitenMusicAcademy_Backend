package com.jpmware.JitenMusicAcademyBackend;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpmware.JitenMusicAcademyBackend.dao.course.CourseDAO;
import com.jpmware.JitenMusicAcademyBackend.dao.instructor.InstructorDAO;
import com.jpmware.JitenMusicAcademyBackend.dao.student.StudentDAO;
import com.jpmware.JitenMusicAcademyBackend.entity.Class;
import com.jpmware.JitenMusicAcademyBackend.entity.Instructor;
import com.jpmware.JitenMusicAcademyBackend.entity.Student;
import com.jpmware.JitenMusicAcademyBackend.service.student.StudentService;

@SpringBootApplication
public class JitenMusicAcademyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JitenMusicAcademyBackendApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner (StudentService studentService) {
	// 	return runner -> {
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
			// addStudentToCourse(studentDAO, courseDAO);
			// addCourseWithStudents(courseDAO);
			// addCourseToStudent(studentDAO, courseDAO);
			// createInstructor(instructorDAO);
			// findInstructorById(instructorDAO);
			// getAllInstructors(instructorDAO);
			// updateInstructorExperience(instructorDAO);
			// deleteInstructorById(instructorDAO);
			// addCourseToInstructor(instructorDAO, courseDAO);
			// getCourseInstructorByCourseId(courseDAO);
			// showAllStudents(studentService);
	// 	};
	// }

	private void showAllStudents(StudentService studentService) {
		List<Student> students = studentService.getAllStudents();
		System.out.println(students);
	}

	private void getCourseInstructorByCourseId(CourseDAO courseDAO) {
		int course_id = 3;
		Class course = courseDAO.getCourseById(course_id);
		System.out.println(course.getInstructor());
	}

	private void addCourseToInstructor(InstructorDAO instructorDAO, CourseDAO courseDAO) {
		int instructor_id = 3;
		Instructor instructor = instructorDAO.getInstructorWithClassesByInstructorId(instructor_id);
		int course_id = 4;
		Class course = courseDAO.getCourseById(course_id);
		instructor.addClass(course);
		instructorDAO.updateInstructor(instructor);
	}

	private void deleteInstructorById(InstructorDAO instructorDAO) {
		int instructor_id = 1;
		instructorDAO.deleteInstructorById(instructor_id);
	}

	private void updateInstructorExperience(InstructorDAO instructorDAO) {
		int instructor_id = 1;
		Instructor instructor = instructorDAO.getInstructorById(instructor_id);
		instructor.setExperience(7);
		instructorDAO.updateInstructor(instructor);
	}

	private void getAllInstructors(InstructorDAO instructorDAO) {
		List<Instructor> instructors = instructorDAO.getAllInstructors();
		System.out.println(instructors);
	}

	private void findInstructorById(InstructorDAO instructorDAO) {
		int instructor_id = 1;
		Instructor instructor = instructorDAO.getInstructorById(instructor_id);
		System.out.println(instructor);
	}

	private void createInstructor(InstructorDAO instructorDAO) {
		Instructor instructor = new Instructor(
			"Prathamesh", "prathamesh@email.com", 1234567890, 5, null
		);
		instructorDAO.createInstructor(instructor);
	}

	private void addCourseToStudent(StudentDAO studentDAO, CourseDAO courseDAO) {
		int student_id = 2;
		Student student = studentDAO.getStudentWithCoursesByStudentId(student_id);
		int course_id = 4;
		Class course = courseDAO.getCourseById(course_id);
		student.addCourse(course);
		studentDAO.updateStudent(student);
	}

	private void addCourseWithStudents(CourseDAO courseDAO) {
		Class course = new Class("Guitar", "Guitar 101");
		course.addStudent(new Student("Nikhil", "nikhil@email.com", 587654321, null));
		course.addStudent(new Student("Atharva", "atharva@email.com", 312332133, null));
		courseDAO.createCourse(course);
	}

	private void addStudentToCourse(StudentDAO studentDAO, CourseDAO courseDAO) {
		int course_id = 3;
		Class course = courseDAO.getCourseWithStudentsByCourseId(course_id);
		int student_id = 3;
		Student student = studentDAO.getStudentById(student_id);
		course.addStudent(student);
		courseDAO.updateCourse(course);
	}

	private void deleteCourseById(CourseDAO courseDAO) {
		int course_id = 6;
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
		Class course = new Class("Piano", "Western Classical");
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
		Student student = new Student("Jay", "jay@email.com", 1234567890, null);
		studentDAO.createStudent(student);
	}

}
