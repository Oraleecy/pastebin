package com.example.pastebin.models;

public enum Tag {
    JAVA("java"),
    PYTHON("Python"),
    RUBY("Ruby"),
    CSHARP("C#"),
    CPP("C++");

    private final String displayValue;

    private Tag(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
