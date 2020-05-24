package com.company.W3.Customers;
import com.company.W3.Core.Product;

import java.util.ArrayList;

public class RandomCustomer extends AbstractCustomer {
	
	public RandomCustomer() {
		shoppingList = new ArrayList<Product>();
		
		int noProducts;
		
		/* 
		 * a different form of for loop:
		 * iterate over all values of the enum
		 * in each iteration, t has a different value
		 * 
		 * Product.type.values() returns an array of
		 * enum values, and we can loop over all values of
		 * an array as follows too
		 * 
		 * it is equivalent to: 
		 * Product.type[] types = Product.type.values();
		 * for (int i = 0; i < types.length; i++) {
		 * 	...
		 * }
		 * 
		 * the colon notation can be used for any array
		 */
		for (Product.type t : Product.type.values()) {
			//generate a random int between 0 and 2 (inclusive)
			noProducts = (int) Math.floor(Math.random() * 3);
			
			if (noProducts > 0) {
				shoppingList.add(new Product(t, noProducts));
			}
		}
		
		if (shoppingList.isEmpty()) {
			shoppingList.add(new Product(Product.type.Milk, 1));
		}
		
		//generate a random number between 15 and 30 (inclusive)
		setMoney(Math.round(Math.random() * 15) + 15);
	}
	
	public static void main(String [] args) {
		Customer customer = new RandomCustomer();
		System.out.println(customer);
	}
}