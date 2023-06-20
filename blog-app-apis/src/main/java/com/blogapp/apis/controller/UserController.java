package com.blogapp.apis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.apis.paylods.ApiResponse;
import com.blogapp.apis.paylods.UserDto;
import com.blogapp.apis.service.UserServiceI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServiceI userServicesI;

	@PostMapping("/user")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUser=this.userServicesI.createUser(userDto);
		
		return new  ResponseEntity<UserDto>(createUser, HttpStatus.CREATED) ;
		
	}
//	PutMapping
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updatedUser(@Valid 	@RequestBody UserDto userDto,@PathVariable("userId")  Integer uid){
		UserDto updateUser = this.userServicesI.updateUser(userDto, uid);
		return ResponseEntity.ok(updateUser) ; 
		
	}
//	Delete 
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
		this.userServicesI.deletuser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
		
	}
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
		return ResponseEntity.ok(this.userServicesI.getalluser());
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userServicesI.getUserById(userId));
		
	}
	
}
