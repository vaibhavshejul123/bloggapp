package com.blogapp.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogapp.apis.model.User;
import com.blogapp.apis.paylods.UserDto;

public interface UserRepository extends JpaRepository<User, Integer> {

	User save(UserDto user);

}
