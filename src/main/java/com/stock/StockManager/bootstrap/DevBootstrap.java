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
		Category masala = new Category();
		masala.setType("Masala");
		
		Category staples = new Category();
		staples.setType("Staples");
		
		
		Item chilliPowder = new Item();
		chilliPowder.setName("Chilli Powder");
		chilliPowder.setQuantity(2L);
		chilliPowder.setBarcode(564897546L);
		masala.getItems().add(chilliPowder);
		
		//category.getItems().add(chilliPowder);
		itemsRepository.save(chilliPowder);
		
		
		Item atta = new Item();
		atta.setName("Ashirbad");
		atta.setQuantity(10L);
		atta.setBarcode(89789340L);
		staples.getItems().add(atta);
//		atta.setCategory("staple");
		
		//category.getItems().add(atta);
		itemsRepository.save(atta);
		categoryRepository.save(masala);
		categoryRepository.save(staples);

	}
}
