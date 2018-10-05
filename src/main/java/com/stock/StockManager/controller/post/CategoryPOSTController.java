package com.stock.StockManager.controller.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stock.StockManager.model.Category;
import com.stock.StockManager.repository.CategoryRepository;

@RestController
public class CategoryPOSTController {
	
	CategoryRepository categoryRepository;
	
	public CategoryPOSTController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@PostMapping("/categorie")
	public ResponseEntity<Object> createCategory(@RequestBody Category category)
	{
		if(categoryRepository.existsById(category.getType()))
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			categoryRepository.save(category);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
}
