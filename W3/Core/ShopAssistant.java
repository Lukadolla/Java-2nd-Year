package com.company.W3.Core;
import com.company.W3.Core.Product;
import com.company.W3.Core.Shop;
import com.company.W3.Customers.Customer;
import com.company.W3.Customers.SpontaneousCustomer;
import com.company.W3.Loggers.Logger;

import java.util.ArrayList;

public class ShopAssistant {
	private int ID;
	private String name;
	
	private double hoursWorked;
	private double hourlyPay;
	
	private Shop shop;
	
	public ShopAssistant(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public double getHourlyPay() {
		return hourlyPay;
	}

	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}

	public double calculatePay() {
		return hourlyPay * hoursWorked;
	}
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public void serve(Customer c) {
		ArrayList<Product> shoppingList = c.getShoppingList();
		
		if (c instanceof SpontaneousCustomer) {
			shop.getLogger().log(Logger.CUSTOMER_EVENT, c);
		}

		ArrayList<Product> trueList = new ArrayList<Product>();
		
		if (shoppingList != null) {
			//window shoppers return null... 
			double cost = 0;
			Product product;
			for (int i = 0; i < shoppingList.size(); i++) {
				product = shoppingList.get(i);
				if (shop.has(product)) {
					cost += product.getCost();
					//making a new list, to not mutate Customer!
					trueList.add(product);
				} else {
					//being lazy here: if not available remove from list
					//shoppingList.remove(i);
					/* 
					 * we won't mutate customer, but still need to keep track, 
					 * so we use a list in the method of things the customer 
					 * will buy instead
					 */
				}
			}
			
			//added logic for running out of stock, i.e. if cost is 0
			if (cost > 0 && c.canPay(cost)) {
				shop.getCashRegister().add(c.pay(cost));
				//switched lists!
				for (Product p : trueList) {
					shop.sold(p);
				}
			} else {
				if (cost == 0) {
					shop.getLogger().log(Logger.SALE_EVENT, "Shop out of stock, can't serve Customer :(");
				} else {
					shop.getLogger().log(Logger.SALE_EVENT, "Customer can't pay :(");
				}
			}
		}
	}
}
