package com.example.pastebin.models;

public enum ExpirationDateEnum {
    NEVER("Never"),
    BURN_AFTER_READ("Burn after read"),
    TEN_MINUTES("10 Minutes"),
    ONE_HOUR("1 Hour"),
    ONE_DAY("1 Day"),
    ONE_WEEK("1 Week"),
    TWO_WEEKS("2 Weeks"),
    ONE_MONTH("1 Month"),
    SIX_MONTHS("6 Months"),
    ONE_YEAR("1 Year");

    private final String displayValue;

    private ExpirationDateEnum(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
