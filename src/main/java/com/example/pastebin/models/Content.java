package com.example.pastebin.models;


import jakarta.persistence.Entity;


public class Content {
    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
