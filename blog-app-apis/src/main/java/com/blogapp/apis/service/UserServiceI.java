package com.blogapp.apis.service;

import java.util.List;

import com.blogapp.apis.paylods.UserDto;

public interface UserServiceI {

	UserDto createUser(UserDto userDto	);
    UserDto updateUser(UserDto userDto, Integer UserId);
    UserDto getUserById(Integer UserId);
    List<UserDto> getalluser();
    UserDto deletuser(Integer UserId);
}
