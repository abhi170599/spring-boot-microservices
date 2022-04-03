package com.absoft.currencyconversion.beans;

import java.math.BigDecimal;

public class CurrencyConversion {
    
    private String from;
    private String to;
    private long quantity;
    private BigDecimal conversionMultiple;
    private BigDecimal convertedValue;

    public CurrencyConversion() {}
    
    public CurrencyConversion(String from, String to, long quantity, BigDecimal conversionMultiple,
            BigDecimal convertedValue) {
       
        this.from = from;
        this.to = to;
        this.quantity = quantity;
        this.conversionMultiple = conversionMultiple;
        this.convertedValue = convertedValue;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }
}
