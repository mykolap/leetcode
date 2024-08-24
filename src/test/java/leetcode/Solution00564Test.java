package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00564Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void nearestPalindromic(String numberStr, String expected) {
        String actual = new Solution00564().nearestPalindromic(numberStr);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void nearestPalindromicLargerSmaller(String numberStr, String expected) {
        String actual = new Solution00564().nearestPalindromicLargerSmaller(numberStr);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("123", "121"),
                Arguments.of("1234", "1221"),
                Arguments.of("12345", "12321"),
                Arguments.of("1", "0"),
                Arguments.of("2", "1"),
                Arguments.of("10", "9"),
                Arguments.of("11", "9"),
                Arguments.of("100", "99"),
                Arguments.of("101", "99"),
                Arguments.of("1000", "999"),
                Arguments.of("1001", "999")
        );
    }

}