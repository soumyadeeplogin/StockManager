package com.stock.StockManager.repository;

import org.springframework.data.repository.CrudRepository;

import com.stock.StockManager.model.Item;

public interface ItemRepository extends CrudRepository<Item, String>{

}
