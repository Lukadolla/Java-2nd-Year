package com.company.W3.Customers;
import com.company.W3.Core.Product;

import java.util.ArrayList;

public interface Customer {

	boolean canPay(double amount);

	double pay(double amount);

	ArrayList<Product> getShoppingList();
	
	void setShoppingList(ArrayList<Product> shoppingList);

}