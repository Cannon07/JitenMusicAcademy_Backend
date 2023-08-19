package com.jpmware.JitenMusicAcademyBackend.exception;

public class InstructorNotFoundException extends CustomException {
    
    public InstructorNotFoundException(int instructor_id) {
        super("Instructor not found with ID: " + instructor_id);
    }
}
