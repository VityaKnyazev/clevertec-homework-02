package ru.clevertec.knyazev;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {
    private Utils utils;

    @BeforeEach
    public void setUp() {
        utils = new Utils();
    }

    @ParameterizedTest
    @MethodSource("getForIsAllPositiveNumbersNegativeScenario")
    public void checkIsAllPositiveNumbersShouldReturnFalse(String num1,
                                                           String num2,
                                                           String num3) {

        assertThat(utils.isAllPositiveNumbers(num1, num2, num3))
                .isFalse();

    }

    @Test
    public void checkIsAllPositiveNumbersShouldReturnFalseOnNullInput() {

        String[] numbers = null;

        assertThat(utils.isAllPositiveNumbers(numbers))
                .isFalse();

    }

    @ParameterizedTest
    @MethodSource("getForIsAllPositiveNumbersPositiveScenario")
    public void checkIsAllPositiveNumbersShouldReturnTrue(String num1,
                                                           String num2,
                                                           String num3) {

        assertThat(utils.isAllPositiveNumbers(num1, num2, num3))
                .isTrue();

    }

    private static Stream<Arguments> getForIsAllPositiveNumbersNegativeScenario() {

        return Stream.of(
                Arguments.of(null, "12.5", "0.01"),
                Arguments.of("", "12.5", "0.01"),
                Arguments.of(" ", "12.5", "0.01"),
                Arguments.of("0", "12.5", "0.01"),
                Arguments.of("-0", "12.5", "0.01"),
                Arguments.of("-0.0000000000000000001", "12.5", "0.01")
        );

    }

    private static Stream<Arguments> getForIsAllPositiveNumbersPositiveScenario() {

        return Stream.of(
                Arguments.of("0.00000000000000000000001", "12.5", "0.01"),
                Arguments.of("1", "12.5", "0.01"),
                Arguments.of("1.000000001", "12.5", "0.01")
        );

    }

}
