package com.stock.StockManager.controller.get;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.StockManager.model.Category;
import com.stock.StockManager.model.IncomingItem;
import com.stock.StockManager.model.Item;
import com.stock.StockManager.repository.CategoryRepository;
import com.stock.StockManager.repository.ItemRepository;

@RestController
public class ItemGETController {
	ItemRepository itemsRespository;
	CategoryRepository categoryRepository;
	
	public ItemGETController(ItemRepository itemsRespository, CategoryRepository categoryRepository) {
		this.itemsRespository = itemsRespository;
		this.categoryRepository = categoryRepository;
	}
	
	
	@GetMapping(value="/items/all")
	public Iterable<Item> getItems()
	{
		return itemsRespository.findAll();
	}
	
	@GetMapping(value="/item/{id}")
	public Item getItemById(@PathVariable("id") String id)
	{

		Iterator<Item> iterator = itemsRespository.findAll().iterator();
		while(iterator.hasNext())
		{
			Item item = iterator.next();
			if(item.getName().equalsIgnoreCase(id))
				return item;
		}
		
		return null;
	}
	
}
