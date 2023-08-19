package com.jpmware.JitenMusicAcademyBackend.exception.custom;

public class CustomException extends RuntimeException {
    
    // Constructors

    public CustomException(String message) {
        super(message);
    }
    
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }
}
