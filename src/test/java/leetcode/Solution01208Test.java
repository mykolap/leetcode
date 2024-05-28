package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01208Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void equalSubstring(String s, String t, int maxCost, int expected) {
        int result = new Solution01208().equalSubstring(s, t, maxCost);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abcd", "bcdf", 3, 3),
                Arguments.of("abcd", "cdef", 3, 1),
                Arguments.of("abcd", "acde", 0, 1)
        );
    }

}