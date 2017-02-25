package com.stylingandroid.junit5;

enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MODULO("%"),
    UNKNOWN("???");

    private final String name;

    Operator(String name) {
        this.name = name;
    }

    static Operator getOperator(String name) {
        for (Operator operator : values()) {
            if (operator.name.equals(name)) {
                return operator;
            }
        }
        return UNKNOWN;
    }
}
