package com.company.W3.Customers;
import com.company.W3.Core.Product;

import java.util.ArrayList;

public abstract class AbstractCustomer implements Customer {
	
	private double money;
	protected ArrayList<Product> shoppingList;
	
	protected final void setMoney(double d) {
		if (d < 0) {
			throw new CustomerException("Invalid Money Amount: " + d);
		}
		
		money = d;
	}

	protected final double getMoney() {
		return money;
	}
	
	public boolean canPay(double amount) {
		return money > amount;
	}
	
	public ArrayList<Product> getShoppingList() {
		return shoppingList;
	}
	
	public void setShoppingList(ArrayList<Product> list) {
		shoppingList = list;
	}
	
	public double pay(double amount) {
		if (money < amount) {
			throw new CustomerException("Can't Pay " + amount + " only have " + money);
		} else {
			money -= amount;
			return amount;
		}
	}

	public String toString() {
		return getClass().getName() + " " + shoppingList.toString();   
	}
}