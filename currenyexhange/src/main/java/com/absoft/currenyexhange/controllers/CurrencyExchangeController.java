package com.absoft.currenyexhange.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import com.absoft.currenyexhange.entities.CurrencyExchange;
import com.absoft.currenyexhange.exceptions.NotFoundException;
import com.absoft.currenyexhange.repositories.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
    
    @Autowired
    private CurrencyExchangeRepository currencyExcahngeRepository;

    @GetMapping(path="/exchanges")
    public CurrencyExchange retrieveExcahnge(@RequestParam(name="from",required = true) String from,
                                     @RequestParam(name="to",required = true) String to) {
        Optional<CurrencyExchange> exchange = 
                    currencyExcahngeRepository.getByFromAndTo(from,to);
        if(!exchange.isPresent()) {
           throw new NotFoundException(String.format(
               "Currency Exchange not found for from=%s, to=%s",from,to));
        }            

        return exchange.get();
    }

    @PostMapping(path="/exchanges")
    public ResponseEntity<Object> createExchange(@Valid @RequestBody CurrencyExchange exchange){
        CurrencyExchange savedExchange = currencyExcahngeRepository.save(exchange);
        URI location = ServletUriComponentsBuilder
                       .fromCurrentRequest()
                       .queryParam("from",savedExchange.getFrom())
                       .queryParam("to", savedExchange.getTo())
                       .build().toUri(); 
        
        return ResponseEntity.created(location).build();
    }
}
