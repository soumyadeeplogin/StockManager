package com.stock.StockManager.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import com.stock.StockManager.model.Category;
import com.stock.StockManager.model.Item;
import com.stock.StockManager.repository.CategoryRepository;
import com.stock.StockManager.repository.ItemRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private ItemRepository itemsRepository;
	private CategoryRepository categoryRepository;
	
	public DevBootstrap(ItemRepository itemsRepository, CategoryRepository categoryRepository) {
		this.itemsRepository = itemsRepository;
		this.categoryRepository = categoryRepository;
	}
	
	 @Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		 initData();		
	}
	 
	 
	private void initData()
	{
		
		
		
		Item i1 = new Item();
		i1.setName("Chilli Powder");
		i1.setQuantity(1L);
		
		itemsRepository.save(i1);
		
		Item i2 = new Item();
		i2.setName("Cumin Powder");
		i2.setQuantity(2L);
		
		itemsRepository.save(i2);
		
		Category c1 = new Category("Masala");
		c1.getItems().add(i1);
		c1.getItems().add(i2);
		categoryRepository.save(c1);	

	}
}
