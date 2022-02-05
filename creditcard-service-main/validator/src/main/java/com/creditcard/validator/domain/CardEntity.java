package com.creditcard.validator.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "creditcard")
public class CardEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String cardNumber;
	private BigDecimal cardLimit;
	private BigDecimal outstanding;
	private String currency;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public BigDecimal getLimit() {
		return cardLimit;
	}
	public void setLimit(BigDecimal limit) {
		this.cardLimit = limit;
	}
	public BigDecimal getOutstanding() {
		return outstanding;
	}
	public void setOutstanding(BigDecimal outstanding) {
		this.outstanding = outstanding;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
