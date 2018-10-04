package com.stock.StockManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Item {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	private String name;
	private Long barcode;
	private Long quantity;
	
//	@OneToOne
//	private Category category;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;		
	}
	
	public Long getBarcode() {
		return this.barcode;
	}

	public void setBarcode(Long barcode) {
		this.barcode = barcode;		
	}

	public Long getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Long quantity) {
		this.quantity = quantity;		
	}

//	public Category getCategory() {
//		return this.category;
//	}
	
//	public void setCategory(Category category) {
//		this.category = category;		
//	}
	
/*	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return id != null ? id.equals(item.id) : item.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
	
	 @Override
	    public String toString() {
	        return "Item{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", barcode='" + barcode + '\'' +
	                ", quantity=" + quantity + '\'' +
	                ", category='" + category + 
	                '}';
	    }*/
	
	
}
