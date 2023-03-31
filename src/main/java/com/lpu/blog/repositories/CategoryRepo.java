package com.lpu.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
