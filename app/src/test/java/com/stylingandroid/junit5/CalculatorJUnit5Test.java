package com.stylingandroid.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SuppressWarnings("unused")
public class CalculatorJUnit5Test {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Nested
    @DisplayName("Given inputs of One and Two")
    class oneAndTwo {
        float input1 = 1;
        float input2 = 2;

        @Test
        @DisplayName("When we add them Then the result is Three")
        void plus() {
            float result = calculator.calculate(input1, input2, Operator.PLUS);

            assertThat(result).isEqualTo(3f);
        }

        @Test
        @DisplayName("When we subtract them Then the result is Minus One")
        void minus() {
            float result = calculator.calculate(input1, input2, Operator.MINUS);

            assertThat(result).isEqualTo(-1f);
        }

        @Test
        @DisplayName("When we multiply them Then the result is Two")
        void multiply() {
            float result = calculator.calculate(input1, input2, Operator.MULTIPLY);

            assertThat(result).isEqualTo(2f);
        }

        @Test
        @DisplayName("When we divide them Then the result is Zero Point Five")
        void divide() {
            float result = calculator.calculate(input1, input2, Operator.DIVIDE);

            assertThat(result).isEqualTo(0.5f);
        }

        @Test
        @DisplayName("When we modulo them Then the result is One")
        void modulo() {
            float result = calculator.calculate(input1, input2, Operator.MODULO);

            assertThat(result).isEqualTo(1f);
        }

        @Test
        @DisplayName("When we apply an Unknown operator to them Then the result is Zero")
        void unknown() {
            float result = calculator.calculate(input1, input2, Operator.UNKNOWN);

            assertThat(result).isEqualTo(0f);
        }
    }

    @Nested
    @DisplayName("Given inputs of One and Zero")
    class oneAndZero {
        float input1 = 1;
        float input2 = 0;

        @Test
        @DisplayName("When we add them Then the result is One")
        void plus() {
            float result = calculator.calculate(input1, input2, Operator.PLUS);

            assertThat(result).isEqualTo(1f);
        }

        @Test
        @DisplayName("When we subtract them Then the result is One")
        void minus() {
            float result = calculator.calculate(input1, input2, Operator.MINUS);

            assertThat(result).isEqualTo(1f);
        }

        @Test
        @DisplayName("When we multiply them Then the result is Zero")
        void multiply() {
            float result = calculator.calculate(input1, input2, Operator.MULTIPLY);

            assertThat(result).isEqualTo(0f);
        }

        @Test
        @DisplayName("When we divide them Then the result is Infinity")
        void divide() {
            float result = calculator.calculate(input1, input2, Operator.DIVIDE);

            assertThat(result).isEqualTo(Float.POSITIVE_INFINITY);
        }

        @Test
        @DisplayName("When we modulo them Then the result is NaN")
        void modulo() {
            float result = calculator.calculate(input1, input2, Operator.MODULO);

            assertThat(result).isNaN();
        }

        @Test
        @DisplayName("When we apply an Unknown operator to them Then the result is Zero")
        void unknown() {
            float result = calculator.calculate(input1, input2, Operator.UNKNOWN);

            assertThat(result).isEqualTo(0f);
        }
    }
}
