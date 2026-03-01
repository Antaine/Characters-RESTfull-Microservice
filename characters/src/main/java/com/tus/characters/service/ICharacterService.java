package com.tus.characters.service;

import com.tus.characters.dto.CharacterDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;

public interface ICharacterService {

    // Create a new character
    CharacterDto createCharacter(CharacterDto characterDto);

    // Get all characters
    List<CharacterDto> getAllCharacters();

    // Get characters by user ID
    List<CharacterDto> getCharactersByUserId(Long userId);

    // Delete a character by ID
    void deleteCharacter(Long characterId);
    
    List<CharacterDto> getCharactersByDateRange(
    		LocalDate startDate,
    		LocalDate endDate);
    
    void updateCharacter(Long characterId, CharacterDto characterDto);
    
    CharacterDto getCharacterById(Long characterId);
    
    Page<CharacterDto> getCharactersPaginated(int page, int size);
    Page<CharacterDto> getCharactersPage(int page, int size);
    Page<CharacterDto> getCharactersPage(int page,int size,String sortBy,String direction);
}

