package com.example.pastebin.models;

public enum Category {
    NONE("None"),
    CRYPTOCURRENCY("Cryptocurrency"),
    FOOD("Food");

    private final String displayValue;

    private Category(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
