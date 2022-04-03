package com.absoft.currenyexhange.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class CurrencyExchange {
    
    @Id 
    @GeneratedValue
    private long id;

    @Size(max = 3, min = 3,message = "Currency code should be of 3 letters")
    @Column(name="currency_from")
    private String from;

    @Size(max = 3, min = 3,message = "Currency code should be of 3 letters")
    @Column(name="currency_to")
    private String to;

    @Min(value = 1,message = "Conversion multiplier cannot be zero")
    private BigDecimal conversionMultiple;

    public CurrencyExchange() {}

    public CurrencyExchange(int id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }
    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }
}
