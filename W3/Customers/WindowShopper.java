package com.company.W3.Customers;
import com.company.W3.Core.Product;

import java.util.ArrayList;

public class WindowShopper extends AbstractCustomer {
	
	public WindowShopper() {
		//does nothing!
	}

	@Override
	public boolean canPay(double amount) {
		//WindowShoppers don't buy things so false is fine here
		return false;
	}

	@Override
	public double pay(double amount) {
		throw new CustomerException("WindowShoppers Don't Buy Things!");
	}

	@Override
	public ArrayList<Product> getShoppingList() {
		// Don't have one of these
		return null;
	}

	@Override
	public void setShoppingList(ArrayList<Product> shoppingList) {
		//do nothing
	}
	
	public String toString() {
		return "Window Shopper: I don't buy things...";
	}

}
