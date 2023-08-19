package com.jpmware.JitenMusicAcademyBackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jpmware.JitenMusicAcademyBackend.dto.ErrorResponse;
import com.jpmware.JitenMusicAcademyBackend.exception.custom.CustomException;
import com.jpmware.JitenMusicAcademyBackend.exception.custom.InvalidInputException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException exception) {
        
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleInvalidInputException(InvalidInputException exception) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
