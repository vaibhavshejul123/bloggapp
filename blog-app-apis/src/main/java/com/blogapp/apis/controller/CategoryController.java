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
import com.blogapp.apis.paylods.CategoryDto;
import com.blogapp.apis.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
//	create

	/**
	 * author vaibhav
	 * 
	 * @param categryDto
	 * @return
	 */
	@PostMapping("/")
	public ResponseEntity<CategoryDto> creteCategory(@RequestBody CategoryDto categryDto) {

		CategoryDto createCategory = this.categoryService.createCategory(categryDto);

		return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);

	}

//	update
	/**
	 * author vaibbhav
	 * 
	 * @param categryDto
	 * @param catId
	 * @return
	 */
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categryDto,
			@PathVariable Integer catId) {

		CategoryDto updateCategory = this.categoryService.updateCategory(categryDto, catId);

		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);

	}

//	delete
	/**
	 * author vaibhav
	 * 
	 * @param catId
	 * @return
	 */
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer catId) {
		this.categoryService.deletCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is Deleted Successfully", true),
				HttpStatus.OK);

	}

//	get
	/**
	 * author vaibhav
	 * 
	 * @param catId
	 * @return
	 */
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId) {

		CategoryDto categoryDto = this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);

	}

//	getAll
	/**
	 * author vaibhav
	 * 
	 * @return
	 */
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {

		List<CategoryDto> categories = this.categoryService.getCategories();
		return new ResponseEntity<List<CategoryDto>>(categories, HttpStatus.OK);

	}

}
