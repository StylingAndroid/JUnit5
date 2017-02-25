package com.stylingandroid.junit5;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CalculatorJUnit4Test {

    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void givenInputsOfOneAndTwo_whenWeAddThem_thenTheResultIsThree() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.PLUS);

        assertThat(result).isEqualTo(3f);
    }

    @Test
    public void givenInputsOfOneAndTwo_whenWeSubtractThem_thenTheResultIsMinusOne() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.MINUS);

        assertThat(result).isEqualTo(-1f);
    }

    @Test
    public void givenInputsOfOneAndTwo_whenWeMultiplyThem_thenTheResultIsTwo() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.MULTIPLY);

        assertThat(result).isEqualTo(2f);
    }

    @Test
    public void givenInputsOfOneAndTwo_whenWeDivideThem_thenTheResultIsZeroPointFive() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.DIVIDE);

        assertThat(result).isEqualTo(0.5f);
    }

    @Test
    public void givenInputsOfOneAndTwo_whenWeModuloThem_thenTheResultIsOne() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.MODULO);

        assertThat(result).isEqualTo(1f);
    }

    @Test
    public void givenInputsOfOneAndTwo_whenWeApplyAnUnknownOperator_thenTheResultIsZero() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.UNKNOWN);

        assertThat(result).isEqualTo(0f);
    }

    @Test
    public void givenInputsOfOneAndZero_whenWeAddThem_thenTheResultIsOne() {
        float input1 = 1;
        float input2 = 0;

        float result = calculator.calculate(input1, input2, Operator.PLUS);

        assertThat(result).isEqualTo(1f);
    }

    @Test
    public void givenInputsOfOneAndZero_whenWeSubtractThem_thenTheResultOne() {
        float input1 = 1;
        float input2 = 0;

        float result = calculator.calculate(input1, input2, Operator.MINUS);

        assertThat(result).isEqualTo(1f);
    }

    @Test
    public void givenInputsOfOneAndZero_whenWeMultiplyThem_thenTheResultIsZero() {
        float input1 = 1;
        float input2 = 0;

        float result = calculator.calculate(input1, input2, Operator.MULTIPLY);

        assertThat(result).isEqualTo(0f);
    }

    @Test()
    public void givenInputsOfOneAndZero_whenWeDivideThem_thenTheResultIsInfinity() {
        float input1 = 1;
        float input2 = 0;

        float result = calculator.calculate(input1, input2, Operator.DIVIDE);

        assertThat(result).isEqualTo(Float.POSITIVE_INFINITY);
    }

    @Test
    public void givenInputsOfOneAndZero_whenWeModuloThem_thenTheResultIsNaN() {
        float input1 = 1;
        float input2 = 0;

        float result = calculator.calculate(input1, input2, Operator.MODULO);

        assertThat(result).isNaN();
    }

    @Test
    public void givenInputsOfOneAndZero_whenWeApplyAnUnknownOperator_thenTheResultIsZero() {
        float input1 = 1;
        float input2 = 2;

        float result = calculator.calculate(input1, input2, Operator.UNKNOWN);

        assertThat(result).isEqualTo(0f);
    }
}
