package com.jpmware.JitenMusicAcademyBackend;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpmware.JitenMusicAcademyBackend.dao.student.StudentDAO;
import com.jpmware.JitenMusicAcademyBackend.entity.Student;

@SpringBootApplication
public class JitenMusicAcademyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JitenMusicAcademyBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// findStudentById(studentDAO);
			// showAllStudents(studentDAO);
			// updateStudent(studentDAO);
			deleteStudentById(studentDAO);
		};
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
