package com.stylingandroid.junit5;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CalculatorJUnit4Test {
    @Test
    public void test() {
        assertThat(true).isTrue();
    }
}
