package com.tus.characters.dto;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Data
public class CharacterDto {

    @NotNull(message = "UserId cannot be null")
    private Long userId;

    @NotEmpty(message = "Character class cannot be null or empty")
    @Size(max = 50, message = "Character class can have at most 50 characters")
    private String characterClass;

    @NotEmpty(message = "Character race cannot be null or empty")
    @Size(max = 50, message = "Character race can have at most 50 characters")
    private String characterRace;

    @Min(value = 1, message = "Level must be at least 1")
    @Max(value = 20, message = "Level cannot exceed 20")
    private int level;
}