package com.absoft.currencyconversion.clients;

public class CurrencyExchangeClient {
    
    private static final String HOST = "http://127.0.0.1:8000";
    private static final String GET_EXCHANGE = "/exchanges?from=%s&to=%s";

    public static String getExchangeUrl(String from,String to) {
        return String.format(HOST+GET_EXCHANGE, from,to);
    }
}
