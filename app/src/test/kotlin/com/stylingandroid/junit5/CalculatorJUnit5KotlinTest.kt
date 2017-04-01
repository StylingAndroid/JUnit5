package com.stylingandroid.junit5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import java.util.Locale
import kotlin.collections.LinkedHashSet

@SuppressWarnings("unused")
class CalculatorJUnit5KotlinTest {
    private var calculator = Calculator()
    private val input1 = 1f

    @TestFactory
    @DisplayName("Given inputs of One and Two")
    internal fun oneAndTwo(): Collection<DynamicTest> {
        val input2 = 2f
        val tests = LinkedHashSet<DynamicTest>(6)
        tests.add(createTest(input1, input2, Operator.PLUS, 3f))
        tests.add(createTest(input1, input2, Operator.MINUS, -1f))
        tests.add(createTest(input1, input2, Operator.MULTIPLY, 2f))
        tests.add(createTest(input1, input2, Operator.DIVIDE, 0.5f))
        tests.add(createTest(input1, input2, Operator.MODULO, 1f))
        tests.add(createTest(input1, input2, Operator.UNKNOWN, 0f))
        return tests
    }

    @TestFactory
    @DisplayName("Given inputs of One and Zero")
    internal fun oneAndZero(): Collection<DynamicTest> {
        val input2 = 0f
        val tests = LinkedHashSet<DynamicTest>(6)
        tests.add(createTest(input1, input2, Operator.PLUS, 1f))
        tests.add(createTest(input1, input2, Operator.MINUS, 1f))
        tests.add(createTest(input1, input2, Operator.MULTIPLY, 0f))
        tests.add(createTest(input1, input2, Operator.DIVIDE, Float.POSITIVE_INFINITY))
        tests.add(createTest(input1, input2, Operator.MODULO, Float.NaN))
        tests.add(createTest(input1, input2, Operator.UNKNOWN, 0f))
        return tests
    }

    private fun createTest(value1: Float, value2: Float, operator: Operator, expected: Float): DynamicTest {
        val displayName = String.format(Locale.getDefault(), "When we %s them Then the result is %.2f", operator.name, expected)
        return dynamicTest(displayName) {
            val result = calculator.calculate(value1, value2, operator)

            assertThat(result).isEqualTo(expected)
        }
    }
}
