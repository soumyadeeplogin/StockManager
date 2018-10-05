package com.stock.StockManager.controller.get;

import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stock.StockManager.model.Category;
import com.stock.StockManager.repository.CategoryRepository;

@RestController
public class CategoryGETController {
	CategoryRepository categoryRepository;
	
	public CategoryGETController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@GetMapping("/categories/all")
	public Iterable<Category> getCategories()
	{
		return categoryRepository.findAll();
	}
	
	@GetMapping("/categorie/{id}")
	public Category getCategory(@PathVariable("id") String type)
	{
		Iterator<Category> iterator = categoryRepository.findAll().iterator();
		while(iterator.hasNext())
		{
			Category category = iterator.next();
			if(category.getType().equalsIgnoreCase(type))
				return category;
		}
		return null;
	}
}
