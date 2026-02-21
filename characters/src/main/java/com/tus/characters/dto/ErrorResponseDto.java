package com.tus.characters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private String apiPath;           // The endpoint that caused the error
    private HttpStatus errorCode;     // HTTP status code
    private String errorMessage;      // Detailed error message
    private LocalDateTime errorTime;  // Timestamp of the error
}