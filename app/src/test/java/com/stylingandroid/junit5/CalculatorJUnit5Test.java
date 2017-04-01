package com.stylingandroid.junit5;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.TestFactory;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@SuppressWarnings("unused")
class CalculatorJUnit5Test {

    private Calculator calculator;
    private final float input1 = 1;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @TestFactory
    @DisplayName("Given inputs of One and Two")
    Collection<DynamicTest> oneAndTwo() {
        final float input2 = 2;
        Set<DynamicTest> tests = new LinkedHashSet<>(6);
        tests.add(createTest(input1, input2, Operator.PLUS, 3f));
        tests.add(createTest(input1, input2, Operator.MINUS, -1f));
        tests.add(createTest(input1, input2, Operator.MULTIPLY, 2f));
        tests.add(createTest(input1, input2, Operator.DIVIDE, 0.5f));
        tests.add(createTest(input1, input2, Operator.MODULO, 1f));
        tests.add(createTest(input1, input2, Operator.UNKNOWN, 0f));
        return tests;
    }

    @TestFactory
    @DisplayName("Given inputs of One and Zero")
    Collection<DynamicTest> oneAndZero() {
        final float input2 = 0;
        Set<DynamicTest> tests = new LinkedHashSet<>(6);
        tests.add(createTest(input1, input2, Operator.PLUS, 1f));
        tests.add(createTest(input1, input2, Operator.MINUS, 1f));
        tests.add(createTest(input1, input2, Operator.MULTIPLY, 0f));
        tests.add(createTest(input1, input2, Operator.DIVIDE, Float.POSITIVE_INFINITY));
        tests.add(createTest(input1, input2, Operator.MODULO, Float.NaN));
        tests.add(createTest(input1, input2, Operator.UNKNOWN, 0f));
        return tests;
    }

    private DynamicTest createTest(final float value1, final float value2, final Operator operator, final float expected) {
        String displayName = String.format(Locale.getDefault(), "When we %s them Then the result is %.2f", operator.name(), expected);
        return dynamicTest(displayName, new Executable() {
            @Override
            public void execute() throws Throwable {
                float result = calculator.calculate(value1, value2, operator);

                assertThat(result).isEqualTo(expected);
            }
        });
    }
}
