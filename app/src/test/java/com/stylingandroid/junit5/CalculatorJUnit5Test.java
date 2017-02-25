package com.stylingandroid.junit5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CalculatorJUnit5Test {

    @Test
    void test() {
        assertThat(true).isTrue();
    }
}
