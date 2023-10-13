package ru.clevertec.knyazev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    private StringUtils stringUtils;

    @BeforeEach
    public void setUp() {
        stringUtils = new StringUtils();
    }

    @ParameterizedTest
    @MethodSource("getNumberForIsPositiveNumberNegativeScenario")
    public void checkIsPositiveNumberShouldReturnFalse(String number) {

        assertThat(stringUtils.isPositiveNumber(number))
                .isFalse();

    }

    @ParameterizedTest
    @MethodSource("getNumberForIsPositiveNumberPositiveScenario")
    public void checkIsPositiveNumberShouldReturnTrue(String number) {

        assertThat(stringUtils.isPositiveNumber(number))
                .isTrue();

    }

   private static Stream<String> getNumberForIsPositiveNumberNegativeScenario() {
        return Stream.of(
                null,
                "",
                " ",
                "absent",
                "-0",
                "1.dsd",
                "d.125"
        );
   }

    private static Stream<String> getNumberForIsPositiveNumberPositiveScenario() {
        return Stream.of(
                "1",
                "56",
                "56.26",
                "0.000000000001",
                "1000000",
                "100000000000000000000000000"
        );
    }

}
