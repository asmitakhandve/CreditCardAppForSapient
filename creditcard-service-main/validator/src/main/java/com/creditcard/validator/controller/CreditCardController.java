package com.creditcard.validator.controller;

import org.springframework.web.bind.annotation.RestController;

import com.creditcard.validator.domain.Card;
import com.creditcard.validator.service.CreditCardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class CreditCardController {
	
	@Autowired
	private CreditCardService ccservice;
	
	/*
	 * http://localhost:8080/api/v1/creditcard/add 
	 */
	
	@PostMapping(path ="/v1/creditcard/add",  consumes = "application/json", produces = "application/json")
	public ResponseEntity<Card> addCreditCard(@RequestBody Card request) throws Exception {
		Card resp = null;
		if (request != null) {
			resp = ccservice.addNewCard(request);
			return ResponseEntity.ok().body(resp);
		}
		return ResponseEntity.badRequest().build();

	}
	/*
	 * http://localhost:8080/api/v1/creditcard/all 
	 */
	@GetMapping("/v1/creditcard/all")
	public ResponseEntity<List<Card>> getAllCards() {
		List<Card> cards = ccservice.getAllCards();
		if(!cards.isEmpty()) {
			return ResponseEntity.ok().body(cards);
		} 
		return ResponseEntity.noContent().build();
	}

}
