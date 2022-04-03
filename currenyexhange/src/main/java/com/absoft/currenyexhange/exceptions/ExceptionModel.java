package com.absoft.currenyexhange.exceptions;

import java.util.Date;

public class ExceptionModel {
    
    private String message;
    private Date timestamp;
    private String details;

    public ExceptionModel() {}
    
    public ExceptionModel(String message, Date timestamp, String details) {
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
