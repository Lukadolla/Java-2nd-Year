package com.company.W3.Loggers;

import java.util.Date;

public class PrintLogger implements Logger {
	
	public PrintLogger() {}

	@Override
	public void log(int eventType, Object o) {
		String msg;
		
		switch(eventType) {
		case Logger.CUSTOMER_EVENT:
			msg = "Customer event";
			break;
		case Logger.SALE_EVENT:
			msg = "Sale event";
			break;
		case Logger.SHOP_EVENT:
			msg = "Shop event";
			break;
		default:
			msg = "Unknown event type: " + eventType;
		}
		
		outputMessage(msg + " [" + new Date() + "] " + o);
		
	}
	
	protected void outputMessage(String s) {
		System.out.println(s);
	}

}
