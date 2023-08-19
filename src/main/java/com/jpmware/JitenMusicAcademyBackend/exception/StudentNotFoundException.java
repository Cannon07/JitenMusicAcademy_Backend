package com.jpmware.JitenMusicAcademyBackend.exception;

public class StudentNotFoundException extends CustomException {
    
    public StudentNotFoundException(int student_id) {
        super("Student not found with ID: " + student_id);
    }
}
