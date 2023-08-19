package com.jpmware.JitenMusicAcademyBackend.exception.custom;

public class StudentNotFoundException extends CustomException {
    
    public StudentNotFoundException(int student_id) {
        super("Student not found with ID: " + student_id);
    }
}
