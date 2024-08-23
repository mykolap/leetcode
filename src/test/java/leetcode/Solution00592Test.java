package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00592Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void fractionAdditionBigDecimal(String expression, String expected) {
        String actual = new Solution00592().fractionAdditionBigDecimal(expression);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void fractionAddition(String expression, String expected) {
        String actual = new Solution00592().fractionAddition(expression);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("-1/2+1/2", "0/1"),
                Arguments.of("-1/2+1/2+1/3", "1/3"),
                Arguments.of("1/3-1/2", "-1/6"),
                Arguments.of("5/3+1/3", "2/1")
        );
    }

}