package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00664Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void strangePrinter(String s, int expected) {
        int result = new Solution00664().strangePrinter(s);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("aaabbb", 2),
                Arguments.of("aba", 2),
                Arguments.of("abcabc", 5),
                Arguments.of("ababab", 4),
                Arguments.of("abacab", 4),
                Arguments.of("abacaba", 4)
        );
    }

}