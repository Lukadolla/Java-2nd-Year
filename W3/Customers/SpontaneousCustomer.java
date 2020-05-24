package com.company.W3.Customers;
import com.company.W3.Core.Product;

import java.util.ArrayList;

public class SpontaneousCustomer extends AbstractCustomer {
	
	public SpontaneousCustomer() {
		//generate a random number between 15 and 30 (inclusive)
		setMoney(Math.round(Math.random() * 15) + 15);
	}
	
	@Override
	public ArrayList<Product> getShoppingList() {
		
		if (shoppingList == null) {
			//we haven't initialised the shopping list yet, so do that here
			
			shoppingList = new ArrayList<Product>();
			//copied from RandomCustomer's constructor:
			int noProducts;
			
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
		}
		
		return shoppingList;
	}

	@Override
	public void setShoppingList(ArrayList<Product> shoppingList) {
		throw new CustomerException("Don't tell me what to do!");
	}
	
	@Override
	public String toString() {
		if (shoppingList == null) {
			return "Spontaneous Customer: I haven't decided yet!";
		} else {
			return "Spontaneous Customer: " + shoppingList.toString();
		}
	}

}
