package com.absoft.currencyconversion.controllers;

import java.math.BigDecimal;

import com.absoft.currencyconversion.beans.CurrencyConversion;
import com.absoft.currencyconversion.exceptions.NotFoundException;

import static com.absoft.currencyconversion.clients.CurrencyExchangeClient.getExchangeUrl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
    
    @GetMapping(path="/v1/convert")
    public CurrencyConversion convertCurrency(@RequestParam(name="from",required = true) String from,
                                              @RequestParam(name="to",required = true) String to,
                                              @RequestParam(name="quantity",required = true) long quantity) {
            
            String url = getExchangeUrl(from, to);
            System.out.println(url);                                    
            ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity
                        (url, CurrencyConversion.class);
            
            if(responseEntity.getStatusCode() == HttpStatus.NOT_FOUND){
                throw new NotFoundException(String.format(
                    "Currency Exchange not found for from = %s, to = %s",from,to));
            }
            
            CurrencyConversion currencyConversion = responseEntity.getBody();
            currencyConversion.setQuantity(quantity);
            currencyConversion.setConvertedValue(
                currencyConversion.getConversionMultiple().multiply(
                    BigDecimal.valueOf(quantity)
                )
            );
            
            return currencyConversion;                                   
    }
}
