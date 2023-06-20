package com.blogapp.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.apis.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
