package com.stylingandroid.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SuppressWarnings("unused")
public class CalculatorJUnit5Test {

    private Calculator calculator;
    final float input1 = 1;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Nested
    @DisplayName("Given inputs of One and Two")
    class oneAndTwo {
        final float input2 = 2;

        @Test
        @DisplayName("When we add them Then the result is Three")
        void plus() {
            performTest(input1, input2, Operator.PLUS, 3f);
        }

        @Test
        @DisplayName("When we subtract them Then the result is Minus One")
        void minus() {
            performTest(input1, input2, Operator.MINUS, -1f);
        }

        @Test
        @DisplayName("When we multiply them Then the result is Two")
        void multiply() {
            performTest(input1, input2, Operator.MULTIPLY, 2f);
        }

        @Test
        @DisplayName("When we divide them Then the result is Zero Point Five")
        void divide() {
            performTest(input1, input2, Operator.DIVIDE, 0.5f);
        }

        @Test
        @DisplayName("When we modulo them Then the result is One")
        void modulo() {
            performTest(input1, input2, Operator.MODULO, 1f);
        }

        @Test
        @DisplayName("When we apply an Unknown operator to them Then the result is Zero")
        void unknown() {
            performTest(input1, input2, Operator.UNKNOWN, 0f);
        }
    }

    @Nested
    @DisplayName("Given inputs of One and Zero")
    class oneAndZero {
        final float input2 = 0;

        @Test
        @DisplayName("When we add them Then the result is One")
        void plus() {
            performTest(input1, input2, Operator.PLUS, 1f);
        }

        @Test
        @DisplayName("When we subtract them Then the result is One")
        void minus() {
            performTest(input1, input2, Operator.MINUS, 1f);
        }

        @Test
        @DisplayName("When we multiply them Then the result is Zero")
        void multiply() {
            performTest(input1, input2, Operator.MULTIPLY, 0f);
        }

        @Test
        @DisplayName("When we divide them Then the result is Infinity")
        void divide() {
            performTest(input1, input2, Operator.DIVIDE, Float.POSITIVE_INFINITY);
        }

        @Test
        @DisplayName("When we modulo them Then the result is NaN")
        void modulo() {
            performTest(input1, input2, Operator.MODULO, Float.NaN);
        }

        @Test
        @DisplayName("When we apply an Unknown operator to them Then the result is Zero")
        void unknown() {
            performTest(input1, input2, Operator.UNKNOWN, 0f);
        }
    }

    void performTest(float value1, float value2, Operator operator, float expected) {
        float result = calculator.calculate(value1, value2, operator);

        assertThat(result).isEqualTo(expected);
    }
}
