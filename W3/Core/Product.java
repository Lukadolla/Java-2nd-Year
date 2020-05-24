package com.company.W3.Core;
public class Product {
	
	public enum type {Coffee, Biscuits, Milk, Bacon, Newspaper};
	private type t;
	private int quantity;
	
	public Product(type t, int quantity) {
		this.t = t;
		
		if (quantity < 1) {
			throw new IllegalArgumentException("Quantity must be greater than or equal to 1");
		}
		
		this.quantity = quantity;
	}
	
	public double getCost() {
		switch(t) {
		case Coffee:
			return 4.99 * quantity;
		case Biscuits:
			return 2.99 * quantity;
		case Milk:
			return 2 * quantity;
		case Bacon:
			return 3.79 * quantity;
		default:
			return 1 * quantity;
		}
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public type getType() {
		return t;
	}
	
	public String toString() {
		return quantity + " " + t;
	}
}
