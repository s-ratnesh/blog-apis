package com.lpu.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.lpu.blog.entities.Category;
import com.lpu.blog.exceptions.ResourceNotFoundException;
import com.lpu.blog.payloads.CategoryDto;
import com.lpu.blog.repositories.CategoryRepo;
import com.lpu.blog.services.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat=this.modelMapper.map(categoryDto, Category.class);
		Category addedCat=this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
		
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer CategoryId) {
		Category cat=this.categoryRepo.findById(CategoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","Category Id", CategoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCat= this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer CategoryId) {
		Category cat=this.categoryRepo.findById(CategoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","Category Id", CategoryId));
		
		this.categoryRepo.delete(cat);
		
		
		
		
		

	}

	@Override
	public CategoryDto getCategory(Integer CategoryId) {
		
		
		Category category =this.categoryRepo.findById(CategoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","Category Id", CategoryId));
		
		return this.modelMapper.map(category, CategoryDto.class);
		
		
	}

	@Override
	public List<CategoryDto> getAllCategory(CategoryDto categoryDto) {
		List<Category> categories= this.categoryRepo.findAll();
		categories.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return this.modelMapper.map(categories, CategoryDto.class)
	}

}
