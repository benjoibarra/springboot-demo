package com.example.demo.exception;

import com.example.demo.model.ErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final String INVALID_INPUT_ERR = "Invalid user input!";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Extract all errors and their messages
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(new ErrorResponse(INVALID_INPUT_ERR, errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();

        // Extract all violations and their messages
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            String property = violation.getPropertyPath().toString(); // Path of the invalid parameter
            String message = violation.getMessage(); // Violation message
            errors.put(property, message);
        }
        return new ResponseEntity<>(new ErrorResponse(INVALID_INPUT_ERR, errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse("User not found!", null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MaxUserCountException.class)
    public ResponseEntity<ErrorResponse> handleMaxUserCountException(MaxUserCountException ex) {
        return new ResponseEntity<>(new ErrorResponse("Max user count reached!", null), HttpStatus.BAD_REQUEST);
    }
}
