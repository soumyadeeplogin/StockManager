package com.stock.StockManager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.StockManager.model.Category;
import com.stock.StockManager.repository.CategoryRepository;

@RestController
public class CategoryController {
	CategoryRepository categoryRepository;
	
	public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@RequestMapping("/categories")
	public Iterable<Category> getCategories()
	{
		return categoryRepository.findAll();
	}
	
}
