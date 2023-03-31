package com.lpu.blog.services;

import java.util.List;

import com.lpu.blog.payloads.CategoryDto;

public interface CategoryService {
//	create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	
//	update
	
	CategoryDto updateCategory(CategoryDto categoryDto,Integer CategoryId);
//	delete
	void deleteCategory(Integer CategoryId);
	
	
	
//	get
	CategoryDto getCategory(Integer CategoryId);
	
//	getAll
	List<CategoryDto> getAllCategory(CategoryDto categoryDto);

}
