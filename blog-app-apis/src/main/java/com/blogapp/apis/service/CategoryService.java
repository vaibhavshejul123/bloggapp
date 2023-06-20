package com.blogapp.apis.service;

import java.util.List;

import com.blogapp.apis.paylods.CategoryDto;

public interface CategoryService {
//Create
	CategoryDto createCategory(CategoryDto category);
//update
	CategoryDto updateCategory(CategoryDto categorydto,Integer categoryId);

//delete
	void deletCategory(Integer categoryId);
//	get
	CategoryDto getCategory(Integer categoryId);

//GetAll
	List<CategoryDto> getCategories();
}
