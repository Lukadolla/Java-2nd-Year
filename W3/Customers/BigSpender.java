package com.company.W3.Customers;
import com.company.W3.Core.Product;

import java.util.ArrayList;

public class BigSpender extends AbstractCustomer {
	
	public BigSpender() {
		
		//copy and pasted from RandomCustomer
		shoppingList = new ArrayList<Product>();
		
		int noProducts;
		
		for (Product.type t : Product.type.values()) {
			//generate a random int between 0 and 2 (inclusive)
			noProducts = (int) Math.floor(Math.random() * 3);
			
			//modification for BigSpender:
			noProducts *= 10;
			
			if (noProducts > 0) {
				shoppingList.add(new Product(t, noProducts));
			}
		}
		
		if (shoppingList.isEmpty()) {
			shoppingList.add(new Product(Product.type.Milk, 1));
		}
		
		//modified for BigSpender: they ALWAYS have enough money
		setMoney(1000);
	}

}
