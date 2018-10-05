package com.stock.StockManager.controller.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stock.StockManager.model.Category;
import com.stock.StockManager.model.Item;
import com.stock.StockManager.repository.CategoryRepository;
import com.stock.StockManager.repository.ItemRepository;
import com.stock.StockManager.utility.ItemCategoryJSONMapper;

@RestController
public class ItemPOSTController {
	ItemRepository itemRepository;
	CategoryRepository categoryRepository;
	
	public ItemPOSTController(ItemRepository itemRepository, CategoryRepository categoryRepository) {
		this.itemRepository = itemRepository;
		this.categoryRepository = categoryRepository;
	}
	
	@PostMapping("/item")
	
	public ResponseEntity<Object> createCategory(@RequestBody ItemCategoryJSONMapper json)
	{
		Item item = new Item(json.getName(), json.getQuantity());
		
		System.out.println(item.getName()+" " + item.getQuantity() + " " + json.getCategory());
		
		if(itemRepository.existsById(item.getName()))
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			itemRepository.save(item);
			Category category = categoryRepository.findById(json.getCategory()).get();
			category.getItems().add(item);
			categoryRepository.save(category);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
}
