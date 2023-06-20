package com.blogapp.apis.service;

import java.util.List;

import com.blogapp.apis.model.Category;
import com.blogapp.apis.model.Post;
import com.blogapp.apis.model.User;
import com.blogapp.apis.paylods.PostDto;
import com.blogapp.apis.paylods.PostResponse;

public interface PostService {

//	create


	 PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	 
	 PostDto updatePost(PostDto postDto,Integer postId);
	 
	 void deletePost(Integer postId);
	 
	 PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);
	 
	 PostDto getPostById(Integer postId);
	 
	 List<PostDto> getPostByCategory(Integer categoryId);
	 
	 List<PostDto>getPostByUser(Integer userId);
	 
	 List<PostDto>serachPosts(String keyword);
	

}
