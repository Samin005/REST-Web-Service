package com.samin005.restwebservice.model;

public class BasicAuthBean {

    private String message;

    public BasicAuthBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
