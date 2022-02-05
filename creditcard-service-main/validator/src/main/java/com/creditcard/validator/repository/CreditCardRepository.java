package com.creditcard.validator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.validator.domain.CardEntity;

@Repository
public interface CreditCardRepository extends JpaRepository<CardEntity, Long> {

}
