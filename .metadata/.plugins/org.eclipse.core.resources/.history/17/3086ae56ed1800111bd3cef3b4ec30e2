package com.tus.characters.mapper;

import com.tus.characters.dto.UserDto;
import com.tus.characters.entity.User;

/**
 * Converts User Entity to Data Transfer Object and vice versa
 */
public class UserMapper {

	//Convert User to DTO
	 public static UserDto mapToUserDto(User user, UserDto userDto) {
	        userDto.setUsername(user.getUsername());
	        userDto.setEmail(user.getEmail());
	        userDto.setPassword(user.getPassword());
	        userDto.setMobileNumber(user.getMobileNumber());
	        return userDto;
	    }

	 //Convert DTO to Character
	    public static User mapToUser(UserDto userDto, User user) {
	        user.setUsername(userDto.getUsername());
	        user.setEmail(userDto.getEmail());
	        user.setPassword(userDto.getPassword());
	        userDto.setMobileNumber(user.getMobileNumber());
	        return user;
	    }
}