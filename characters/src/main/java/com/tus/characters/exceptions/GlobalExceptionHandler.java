package com.tus.characters.exceptions;

import com.tus.characters.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Resource Not Found (404)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDto> handleResourceNotFound(
            ResourceNotFoundException ex){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResponseDto(
                        "404",
                        ex.getMessage()));
    }


    // Validation Errors (400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleValidationErrors(
            MethodArgumentNotValidException ex){

        String errorMessage =
                ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ResponseDto(
                        "400",
                        errorMessage));
    }


    // Generic Errors (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleGeneralError(
            Exception ex){

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseDto(
                        "500",
                        "Something went wrong"));
    }

}