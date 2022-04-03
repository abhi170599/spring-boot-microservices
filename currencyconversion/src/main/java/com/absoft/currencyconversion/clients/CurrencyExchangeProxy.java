package com.absoft.currencyconversion.clients;

import com.absoft.currencyconversion.beans.CurrencyConversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
    
    @GetMapping(path="/exchanges")
    public CurrencyConversion retrieveExchange(
        @RequestParam(name="from",required = true) String from,
        @RequestParam(name="to",required=true) String to
    );
}