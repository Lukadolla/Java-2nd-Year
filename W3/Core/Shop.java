package com.company.W3.Core;


import com.company.W3.Customers.*;
import com.company.W3.Loggers.*;
import java.io.*;

public class Shop {
	
	private ShopAssistant assistant;
	private CashRegister register;
	
	private Product bacon, biscuits, coffee, milk, newspaper;
	
	private int STORAGE_SIZE;
	private Logger logger;
	
	public Shop(int storageSize, double openingCredit, ShopAssistant sa) {
		
		STORAGE_SIZE = storageSize;
		
		bacon = new Product(Product.type.Bacon, STORAGE_SIZE);
		biscuits = new Product(Product.type.Biscuits, STORAGE_SIZE);
		coffee = new Product(Product.type.Coffee, STORAGE_SIZE);
		milk = new Product(Product.type.Milk, STORAGE_SIZE);
		newspaper = new Product(Product.type.Newspaper, STORAGE_SIZE);
		
		register = new CashRegister(openingCredit);	
		
		assistant = sa;
		assistant.setHourlyPay(12);
		sa.setShop(this);
	}
	
	public void walkIn(Customer c) {
		logger.log(Logger.CUSTOMER_EVENT, "Serving " + c);
		assistant.serve(c);
	}
	
	public void setLogger(Logger logger) {
		this.logger = logger;
		//cash register needs it too:
		register.setLogger(logger);
	}
	
	public Logger getLogger() {
		return logger;
	}
	
	public CashRegister getCashRegister() {
		return register;
	}
	
	public boolean has(Product p) {
		switch(p.getType()) {
			case Bacon:
				return bacon.getQuantity() > p.getQuantity();
			case Biscuits:
				return biscuits.getQuantity() > p.getQuantity();
			case Coffee:
				return coffee.getQuantity() > p.getQuantity();
			case Milk:
				return milk.getQuantity() > p.getQuantity();
			default:
				return newspaper.getQuantity() > p.getQuantity();
		}		
	}
	
	public void sold(Product p) {
		switch(p.getType()) {
			case Bacon:
				bacon.setQuantity(bacon.getQuantity() - p.getQuantity());
				break;
			case Biscuits:
				biscuits.setQuantity(biscuits.getQuantity() - p.getQuantity());
				break;
			case Coffee:
				coffee.setQuantity(coffee.getQuantity() - p.getQuantity());
				break;
			case Milk:
				milk.setQuantity(milk.getQuantity() - p.getQuantity());
				break;
			default: 
				newspaper.setQuantity(newspaper.getQuantity() - p.getQuantity());
		}
	}
	
	public void close() {
		assistant.setHoursWorked(5);
		register.remove(assistant.calculatePay());
		
		//System.out.println("Today's transactions");
		register.printLastTransactions(100);
		
		//convert this to one call (it's only 1 message really!)
		logger.log(Logger.SHOP_EVENT, "Current Product Numbers\n" + bacon + "\n" + biscuits + "\n" + coffee + 
				"\n" + milk + "\n" + newspaper);
	}
	
	public static void main(String [] args) {
		
		Shop shop = new Shop(100, 200, new ShopAssistant(1, "Frank"));
		shop.setLogger(new FileLogger(new File("C:\\Java Stuff\\log.txt")));

		for (int i = 0; i < 2; i++) {
			shop.walkIn(new RandomCustomer());
			shop.walkIn(new BigSpender());
			shop.walkIn(new WindowShopper());
			shop.walkIn(new SpontaneousCustomer());
		}
		
		shop.close();
	}
}
