package com.blogapp.apis.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.apis.exception.ResourceNotFoundException;
import com.blogapp.apis.model.Category;
import com.blogapp.apis.paylods.CategoryDto;
import com.blogapp.apis.repository.CategoryRepo;
import com.blogapp.apis.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	public CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMopper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = this.modelMopper.map(categoryDto, Category.class);
		Category save = this.categoryRepo.save(cat);
		return this.modelMopper.map(save, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categorydto, Integer categoryId) {
        Category cat=this.categoryRepo.findById(categoryId).orElseThrow(() 
        ->new ResourceNotFoundException("Category","Category Id",categoryId));
		cat.setCategoryTitle(categorydto.getCategoryTitle());
		cat.setCategoryDescription(categorydto.getCategoryDescription());
        Category updated = this.categoryRepo.save(cat);
        	
        return this.modelMopper.map(updated, CategoryDto.class);
	}

	@Override
	public void deletCategory(Integer categoryId) {
 
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() 
		        ->new ResourceNotFoundException("Category","Category Id",categoryId));	
		
	this.categoryRepo.delete(cat);
	
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {

	Category  cat=	this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","category Id",categoryId));
		
		
		return this.modelMopper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		
		List<CategoryDto> catDto = categories.stream().map((cat)->this.modelMopper.map(cat,CategoryDto.class)).collect(Collectors.toList());
		
		return null;
	}

}
