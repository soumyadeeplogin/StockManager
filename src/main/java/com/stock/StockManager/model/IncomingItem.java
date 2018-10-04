package com.stock.StockManager.model;

public class IncomingItem {
	String name;
	Long barcode;
	Long quantity;
	String category;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getBarcode() {
		return barcode;
	}
	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
