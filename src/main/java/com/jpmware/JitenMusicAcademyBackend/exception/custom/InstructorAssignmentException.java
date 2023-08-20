package com.jpmware.JitenMusicAcademyBackend.exception.custom;

public class InstructorAssignmentException extends RuntimeException {
    
    // Constructors 
    
    public InstructorAssignmentException(String message) {
        super(message);
    }
    
    public InstructorAssignmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstructorAssignmentException(Throwable cause) {
        super(cause);
    }
}
