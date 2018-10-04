package com.stock.StockManager.controller;

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
public class ItemController {
	ItemRepository itemsRespository;
	CategoryRepository categoryRepository;
	
	public ItemController(ItemRepository itemsRespository, CategoryRepository categoryRepository) {
		this.itemsRespository = itemsRespository;
		this.categoryRepository = categoryRepository;
	}
	
	
	@GetMapping(value="/items")
	public Set<Item> getItems()
	{
		Set<Item> items = new HashSet<>();
		
		Iterator<Item> iterator = itemsRespository.findAll().iterator();
		while(iterator.hasNext())
		{
			items.add(iterator.next());
		}
		
		return items;
	}
	
	@GetMapping(value="/itemById/{id}")
	public Item getItemById(@PathVariable("id") Long id)
	{

		Iterator<Item> iterator = itemsRespository.findAll().iterator();
		while(iterator.hasNext())
		{
			Item item = iterator.next();
			if(item.getId()==id)
				return item;
		}
		
		return null;
	}
	
	@GetMapping(value="/itemByName/{name}")
	public Item getItemByName(@PathVariable("name") String name)
	{

		Iterator<Item> iterator = itemsRespository.findAll().iterator();
		while(iterator.hasNext())
		{
			Item item = iterator.next();
			if(item.getName().equalsIgnoreCase(name))
				return item;
		}
		
		return null;
	}
	
	
	public boolean hasCategory(String category)
	{
		Iterator<Category> iterator = categoryRepository.findAll().iterator();
		while(iterator.hasNext())
		{
			if(iterator.next().getType().equals(category))
				return true;
		}
		return false;
	}
	
	@PostMapping(value="/items")
	public ResponseEntity<Object> addItem(@RequestBody String item)
	{
		try {
			IncomingItem items = new ObjectMapper().readValue(item, IncomingItem.class);
			Item newItem = new Item();
			newItem.setName(items.getName());
			
			
			
			newItem.setBarcode(items.getBarcode());
			newItem.setQuantity(items.getQuantity());
			
			if(!hasCategory(items.getCategory()))
			{
				Category category = new Category();
				category.setType(items.getCategory());
				category.getItems().add(newItem);			
				itemsRespository.save(newItem);
				categoryRepository.save(category);
			} else {
				
				itemsRespository.save(newItem);
			}
			
			return new ResponseEntity<>(items,HttpStatus.OK);
		}
		catch(ConstraintViolationException e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
