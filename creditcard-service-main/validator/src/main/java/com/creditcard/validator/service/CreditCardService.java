package com.creditcard.validator.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.validator.domain.Card;
import com.creditcard.validator.domain.CardEntity;
import com.creditcard.validator.errors.InvalidCardNumberException;
import com.creditcard.validator.repository.CreditCardRepository;
import com.creditcard.validator.util.LuhnValidator;

@Service
public class CreditCardService {
	
	@Autowired
	private LuhnValidator validator;
	
	@Autowired
	private CreditCardRepository repo;

	@SuppressWarnings("static-access")
	public Card addNewCard(Card request) throws Exception{
		if(request != null && request.getCardNumber() != null) {
			if(validator.checkLuhn(request.getCardNumber())) {
				//Add new Card
				repo.save(mapModelToEntity(request));
			} else {
				throw new InvalidCardNumberException();
			}
		}
		return request;
	}

	private CardEntity mapModelToEntity(Card request) {
		CardEntity entity = new CardEntity();
		entity.setCardNumber(request.getCardNumber());
		entity.setName(request.getName());
		entity.setLimit(new BigDecimal(request.getLimit()));
		entity.setOutstanding(new BigDecimal(0.0));
		entity.setCurrency(request.getCurrency());
		return entity;
	}

	public List<Card> getAllCards() {
		List<Card> cards =  new ArrayList<>();
		Card c1 = new Card("Bobby Fisher", "435665467676753", 10000.0, 200.0, "Pounds" );
		Card c2 = new Card("Ellen Page", "4350005467676753", 20000.0, 500.0, "Pounds" );
		Card c3 = new Card("Sony Erricson", "8885665467676753", 35000.0, 9000.0, "Pounds" );
		Card c4 = new Card("John Turner", "46546467676753", 80000.0, 4500.0, "Pounds" );
		Card c5 = new Card("Jacob Isreal", "32155467676753", 100000.0, 2000.0, "Pounds" );
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		return cards;
	}
	
	

}
