package com.tus.characters.mapper;

import com.tus.characters.dto.CharacterDto;
import com.tus.characters.entity.Character;
import com.tus.characters.entity.User;

public class CharacterMapper {

    public static CharacterDto mapToCharacterDto(Character character) {
        CharacterDto dto = new CharacterDto();
        dto.setUserId(character.getUser().getUserId()); // get ID from User
        dto.setCharacterClass(character.getCharacterClass());
        dto.setCharacterRace(character.getCharacterRace());
        dto.setLevel(character.getLevel());
        return dto;
    }

    public static Character mapToCharacter(CharacterDto dto, User user) {
        Character character = new Character();
        character.setUser(user); // set User object
        character.setCharacterClass(dto.getCharacterClass());
        character.setCharacterRace(dto.getCharacterRace());
        character.setLevel(dto.getLevel());
        return character;
    }
}