package com.absoft.currenyexhange.repositories;

import java.util.Optional;

import com.absoft.currenyexhange.entities.CurrencyExchange;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {

    public Optional<CurrencyExchange> getByFromAndTo(String from, String to);
    
}
