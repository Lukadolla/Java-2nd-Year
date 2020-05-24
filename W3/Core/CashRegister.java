package com.company.W3.Core;
import com.company.W3.Loggers.Logger;

import java.util.ArrayList;

public class CashRegister {

	//instance variable money
	private double money;
	
	//instance variable transactions
	private ArrayList<String> transactions;

	//new instance variable to handle logging
	private Logger logger;

	//constructor
	public CashRegister(double initialAmount) {
		money = initialAmount;
		validateMoney();
		
		//construct transactions
		transactions = new ArrayList<String>();
	}
	
	//new method for logging
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	//method to check money is never < 0
	private void validateMoney() {
		if (money < 0) {
			/*
			 * I've included here an example of how you could define your
			 * own Exception. However the same code, using 
			 * IllegalArgumentException (in all cases where I use
			 * CashRegisterException) instead would answer the question
			 * as specified.
			 */
			throw new CashRegisterException("Money cannot fall below 0");
		}
	}
	
	//money accessor
	public double getMoney() {
		return money;
	}
	
	//money mutator + check for valid amount
	public void setMoney(double d) {
		money = d;
		validateMoney();
	}
	
	//toString method, which reports the amount of money in the cash register
	public String toString() {
		return "Currently " + money + " in the till";
	}
	
	//method to add an amount of money to the register
	//also checks that the amount added is positive
	public void add(double d) {
		//check d is positive, throw exception otherwise
		if (d > 0) {
			//increase money by d
			money += d;
			//add the transaction to the "memory" of the till
			transactions.add("Added " + d + ". Total now: " + money);
		} else {
			throw new CashRegisterException("Can only add positive amounts to the till. Supplied: " + d);
		}
	}
	
	//
	public void remove(double d) {
		//check d is positive, throw exception otherwise
		if (d > 0) {
			//decrease money by d
			money -= d;
			//check money > 0
			validateMoney();
			//add the transaction to the "memory" of the till
			transactions.add("Removed " + d + ". Total now: " + money);
		} else {
			throw new CashRegisterException("Can only remove positive amounts to the till. Supplied: " + d);
		}
	}
	
	public void printLastTransactions(int noTransactions) {
		
		//needed to build output String
		String output = "Today's transactions:";
		
		if (noTransactions < 1) {
			//throw error now instead of warning message
			throw new IllegalArgumentException("noTransactions needs to be greater than or equal to 1");
		} else if (noTransactions > transactions.size()) {
			for (int i = 0; i < transactions.size(); i++) {
				output = output + "\n" + transactions.get(i);
			}
		} else {
			//otherwise print the last noTransactions of transactions
			for (int i = transactions.size() - noTransactions; i < transactions.size(); i++) {
				output = output + "\n" + transactions.get(i);
			}
		}
		
		logger.log(Logger.SHOP_EVENT, output);
	}

	public static void main(String[] args) {
		CashRegister cashRegister = new CashRegister(500);
		
		cashRegister.add(10);
		System.out.println(cashRegister);
		
		cashRegister.remove(20);
		System.out.println(cashRegister);
		
		//should throw exception
		try {
			cashRegister.add(-20);
		} catch (CashRegisterException ex) {
			ex.printStackTrace();
		}
		
		//should throw exception
		try {
			cashRegister.remove(20000);
		} catch (CashRegisterException ex) {
			ex.printStackTrace();
		}
		
		//should print 2 rows
		cashRegister.printLastTransactions(5);

		//should show error message
		cashRegister.printLastTransactions(-1);
	}
}

/*
 * exception class -- this class could be included in another
 * .java file, but doesn't have to be. I haven't included it
 * mainly to not have to upload to .java files, but it's not
 * incorrect to do this, the class is so small, and won't be 
 * used outside of this class, that this is ok really. However,
 * do not get into the habit of putting MULTIPLE classes in one
 * .java file. In any case, you cannot have 2 public classes in 
 * one .java file anyway!
 * 
 * Note that in this instance
 * no class outside the package (I didn't make one, but if I had)
 * would be able to access this class
 */

class CashRegisterException extends RuntimeException {
	//constructor, which takes an error message as input
	public CashRegisterException(String s) {
		/*
		 * hands the input to the superclass, i.e.
		 * calls the constructor of RuntimeException, passing
		 * s as input
		 * 
		 * all methods of RuntimeException are inherited by 
		 * CashRegisterException
		 */
		super(s);
	}
}