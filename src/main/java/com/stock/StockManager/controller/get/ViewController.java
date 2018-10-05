package com.stock.StockManager.controller.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.StockManager.repository.CategoryRepository;
import com.stock.StockManager.repository.ItemRepository;

@Controller
public class ViewController {
	ItemRepository itemRepository;
	CategoryRepository categoryRepository;
	
	@Autowired
	public ViewController(ItemRepository itemRepository, CategoryRepository categoryRepository) {
		this.itemRepository = itemRepository;
		this.categoryRepository = categoryRepository;
	}
	
	@RequestMapping({"/",""})
	public String showJoke(Model model)
	{

		
		model.addAttribute("categories", categoryRepository.findAll());
		
		return "StockManager";
	}
}
