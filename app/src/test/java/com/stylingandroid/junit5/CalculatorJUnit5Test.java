package com.stylingandroid.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CalculatorJUnit5Test {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Given inputs of One and Two When we add them Then the result is Three")
    public void testOnePlusTwoEqualsThree() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.PLUS);

        assertThat(result).isEqualTo(3f);
    }

    @Test
    @DisplayName("Given inputs of One and Two When we subtract them Then the result is Minus One")
    public void testOneMinusTwoEqualsMinusOne() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.MINUS);

        assertThat(result).isEqualTo(-1f);
    }

    @Test
    @DisplayName("Given inputs of One and Two When we multiply them Then the result is Two")
    public void testOneMultiplyTwoEqualsTwo() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.MULTIPLY);

        assertThat(result).isEqualTo(2f);
    }

    @Test
    @DisplayName("Given inputs of One and Two When we divide them Then the result is Zero Point Five")
    public void testOneDivideTwoEqualsZeroPointFive() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.DIVIDE);

        assertThat(result).isEqualTo(0.5f);
    }

    @Test
    @DisplayName("Given inputs of One and Two When we modulo them Then the result is One")
    public void testOneModuloTwoEqualsOne() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.MODULO);

        assertThat(result).isEqualTo(1f);
    }

    @Test
    @DisplayName("Given inputs of One and Two When we apply an unknown operator them Then the result is Zero")
    public void testOneUnknownTwoEqualsZero() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.UNKNOWN);

        assertThat(result).isEqualTo(0f);
    }

    @Test
    @DisplayName("Given inputs of One and Zero When we add them Then the result is One")
    public void testOnePlusZeroEqualsOne() {
        float input1 = 1;
        float input2 = 0;

        float result = calculator.calculate(input1, input2, Operator.PLUS);

        assertThat(result).isEqualTo(1f);
    }

    @Test
    @DisplayName("Given inputs of One and Zero When we subtract them Then the result is One")
    public void testOneMinusZeroEqualsOne() {
        float input1 = 1;
        float input2 = 0;

        float result = calculator.calculate(input1, input2, Operator.MINUS);

        assertThat(result).isEqualTo(1f);
    }

    @Test
    @DisplayName("Given inputs of One and Zero When we multiply them Then the result is Zero")
    public void testOneMultiplyZeroEqualsZero() {
        float input1 = 1;
        float input2 = 0;

        float result = calculator.calculate(input1, input2, Operator.MULTIPLY);

        assertThat(result).isEqualTo(0f);
    }

    @Test()
    @DisplayName("Given inputs of One and Zero When we divide them Then the result is Infinity")
    public void testOneDivideZeroEqualsInfinity() {
        float input1 = 1;
        float input2 = 0;

        float result = calculator.calculate(input1, input2, Operator.DIVIDE);

        assertThat(result).isEqualTo(Float.POSITIVE_INFINITY);
    }

    @Test
    @DisplayName("Given inputs of One and Two When we modulo them Then the result is NaN")
    public void testOneModuloZeroEqualsNaN() {
        float input1 = 1;
        float input2 = 0;

        float result = calculator.calculate(input1, input2, Operator.MODULO);

        assertThat(result).isNaN();
    }

    @Test
    @DisplayName("Given inputs of One and Zero When we apply an unknown operator to them Then the result is Zero")
    public void testOneUnknownZeroEqualsZero() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.UNKNOWN);

        assertThat(result).isEqualTo(0f);
    }
}
