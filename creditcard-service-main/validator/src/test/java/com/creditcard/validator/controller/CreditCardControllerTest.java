package com.creditcard.validator.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.creditcard.validator.domain.Card;
import com.creditcard.validator.service.CreditCardService;

@SuppressWarnings("deprecation")
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CreditCardControllerTest {

	@Autowired
	private MockMvc mvc;

	@InjectMocks
	private CreditCardController controller;
    @Mock
    CreditCardService service;
	
	  	   
	   @Test
	    public void testGetAllCards()     {
		   List<Card> cards =  new ArrayList<>();
		   // given
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
	        when(service.getAllCards()).thenReturn(cards);	 
	        // when
	        ResponseEntity<List<Card>> result = controller.getAllCards();	        
	        // then
	        assertThat(result.getBody().size()).isEqualTo(5);	         
	        assertThat(result.getBody().get(0).getName()).isEqualTo(c1.getName());
	        assertThat(result.getBody().get(0).getCardNumber()).isEqualTo(c1.getCardNumber());
	    }
	   
	   @Test
	    public void testAddCreditCard() throws Exception 
	    {
	        MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	         
	        when(service.addNewCard(any(Card.class))).thenReturn(any(Card.class));
	         
	        Card c6 = new Card("Jack Black", "434355467676753", 110000.0, 0.0, "Pounds" );
	        ResponseEntity<Card> responseEntity = controller.addCreditCard(c6);
	         
	        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	        
	    }

	
}
