package com.jpmware.JitenMusicAcademyBackend.exception.custom;

public class StudentEnrollmentException extends RuntimeException {

    // Constructors 
    
    public StudentEnrollmentException(String message) {
        super(message);
    }
    
    public StudentEnrollmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentEnrollmentException(Throwable cause) {
        super(cause);
    }

}
