package com.blogapp.apis.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.apis.exception.ResourceNotFoundException;
import com.blogapp.apis.model.User;
import com.blogapp.apis.paylods.UserDto;
import com.blogapp.apis.repository.UserRepository;
import com.blogapp.apis.service.UserServiceI;
@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepository.save(user);
		UserDto userToDto = this.userToDto(savedUser);
		return userToDto;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer UserId) {
		User user2 = this.userRepository.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", UserId));

		user2.setUserName(userDto.getUserName());
		user2.setEmail(userDto.getEmail());
		user2.setPassword(userDto.getPassword());
		user2.setAbout(userDto.getAbout());

		User userUpdate = this.userRepository.save(user2);
		UserDto userDto1 = this.userToDto(userUpdate);
		return userDto1;

	}

	@Override
	public UserDto getUserById(Integer UserId) {
		User user2 = this.userRepository.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", UserId));
		
		return this.userToDto(user2);
	}

	@Override
	public List<UserDto> getalluser() {
		List<User> users = this.userRepository.findAll();
		List<UserDto> UserDtos=users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return UserDtos;
	}

	@Override
	public UserDto deletuser(Integer UserId) {
		User user2 = this.userRepository.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", UserId));

		this.userRepository.delete(user2);
		return null;
	}

	private User dtoToUser(UserDto userDto) {
		User user = this.modelmapper.map(userDto, User.class);
//		user.setUserId(userDto.getUserId());
//		user.setUserName(userDto.getUserName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
	}

	public UserDto userToDto(User user) {

		UserDto userDto = this.modelmapper.map(user, UserDto.class);
//		userDto.setUserId(user.getUserId());
//		userDto.setUserName(user.getUserName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
		return userDto;
	}

}
