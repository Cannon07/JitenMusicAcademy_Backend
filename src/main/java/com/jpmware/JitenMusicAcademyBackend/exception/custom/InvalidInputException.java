package com.jpmware.JitenMusicAcademyBackend.exception.custom;

public class InvalidInputException extends RuntimeException {
    
    // Constructors
    
    public InvalidInputException(String message) {
        super(message);
    }
    
    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputException(Throwable cause) {
        super(cause);
    }
}
