package com.tus.characters.controller;

import com.tus.characters.constants.CharacterConstants;
import com.tus.characters.dto.CharacterDto;
import com.tus.characters.dto.ResponseDto;
import com.tus.characters.service.impl.CharacterServiceImpl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/characters")  // <--- important
@RequiredArgsConstructor
public class CharactersController {
    private final CharacterServiceImpl characterService;

    // Create a new character
    @PostMapping
    public ResponseEntity<ResponseDto> createCharacter(@Valid @RequestBody CharacterDto characterDto) {
        characterService.createCharacter(characterDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CharacterConstants.STATUS_201, CharacterConstants.MESSAGE_201_CREATE));
    }

    // Get all characters
    @GetMapping
    public ResponseEntity<List<CharacterDto>> getAllCharacters() {
        List<CharacterDto> characters = characterService.getAllCharacters();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(characters);
    }

    // Get characters by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CharacterDto>> getCharactersByUserId(@PathVariable Long userId) {
        List<CharacterDto> characters = characterService.getCharactersByUserId(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(characters);
    }

    // Delete a character by ID
    @DeleteMapping("/{characterId}")
    public ResponseEntity<ResponseDto> deleteCharacter(@PathVariable Long characterId) {
        characterService.deleteCharacter(characterId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(CharacterConstants.STATUS_200, "Character deleted successfully"));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<CharacterDto>> getCharactersByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        return ResponseEntity.ok(
                characterService.getCharactersByDateRange(startDate, endDate));
    }
    
    @PutMapping("/{characterId}")
    public ResponseEntity<ResponseDto> updateCharacter(
            @PathVariable Long characterId,
            @Valid @RequestBody CharacterDto characterDto) {

        characterService.updateCharacter(characterId, characterDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(
                        CharacterConstants.STATUS_200,
                        "Character updated successfully"));
    }
    
    @GetMapping("/{characterId}")
    public ResponseEntity<CharacterDto> getCharacterById(
            @PathVariable Long characterId){

        return ResponseEntity.ok(
                characterService.getCharacterById(characterId));
    }

	
	@GetMapping("sayHello")
	public String sayHello() {
		return "Hello World";
	}
}
