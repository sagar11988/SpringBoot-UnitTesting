package com.sds.unitTesting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Product {
	
	@Id
	private int productId;
	private String name;
	private double price;
	private boolean status;
	private int quantity;
	
	@Transient
	private double value;
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", status=" + status
				+ ", quantity=" + quantity + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Product() {}
	
	public Product(int productId, String name, double price, boolean status, int quantity) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.status = status;
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
