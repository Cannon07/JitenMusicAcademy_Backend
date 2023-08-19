package com.jpmware.JitenMusicAcademyBackend.exception;

public class ClassNotFoundException extends CustomException {

    public ClassNotFoundException(int class_id) {
        super("Class not found with ID: " + class_id);
    }
    
}
