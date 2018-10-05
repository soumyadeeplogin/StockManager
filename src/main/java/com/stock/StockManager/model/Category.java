package com.stock.StockManager.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Category {
	
	@Id
	@Column(unique=true)
	private String type;
	
	@OneToMany
	private Set<Item> items = new HashSet<Item>();
	
	
	public Category() {

	}
	
	public Category(String type) {
		this.type = type;
	}
	
	
	public String getType() {
		return type;
	}
	
//	private void setType(String type) {
//		this.type = type;
//	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	
	
}
