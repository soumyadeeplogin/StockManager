package com.stock.StockManager.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.StockManager.model.Item;
import com.stock.StockManager.repository.ItemRepository;

@RestController
public class ItemController {
	ItemRepository itemsRespository;
	
	public ItemController(ItemRepository itemsRespository) {
		this.itemsRespository = itemsRespository;
	}
	
	@RequestMapping("/items")
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
	
	@RequestMapping("/itemById/{id}")
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
	
	@RequestMapping("/itemByName/{name}")
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
}
