package com.tus.characters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {

    private String statusCode; // e.g., "200" or "201"
    private String statusMsg;  // e.g., "User created successfully"
}