package com.creditcard.validator.domain;


public class Card {
	
	private String name;
	private String cardNumber;
	private double cardLimit;
	private double outstanding;
	private String currency;
	
	public Card(String name, String number, double limit, double outStanding, String curr) {
		this.name = name;
		this.cardNumber = number;
		this.cardLimit = limit;
		this.outstanding = outStanding;
		this.currency = curr;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public double getLimit() {
		return cardLimit;
	}
	public void setLimit(double limit) {
		this.cardLimit = limit;
	}
	public double getOutstanding() {
		return outstanding;
	}
	public void setOutstanding(double outstanding) {
		this.outstanding = outstanding;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	

}
