package com.stock.StockManager.repository;

import org.springframework.data.repository.CrudRepository;

import com.stock.StockManager.model.Category;

public interface CategoryRepository extends CrudRepository<Category, String>{

}
