package com.blogapp.apis.paylods;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

	private Long categoryId;

	@NotBlank
	@Size(min = 4, message = "Minimum size of Category Title is 4")
	private String categoryTitle;

	@NotBlank
	@Size(min = 10, message = "Minimum size of category description should be 10")
	private String categoryDescription;
}
