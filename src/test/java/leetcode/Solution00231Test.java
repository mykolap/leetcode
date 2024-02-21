package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00231Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isPowerOfTwoBinary(int n, boolean expected) {
        Solution00231 solution = new Solution00231();
        boolean result = solution.isPowerOfTwoBinary(n);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(Integer.MIN_VALUE, false),
                Arguments.of(-1, false),
                Arguments.of(0, false),
                Arguments.of(1, true),
                Arguments.of(16, true),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(5, false),
                Arguments.of(Integer.MAX_VALUE, false)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isPowerOfTwoBitCount(int n, boolean expected) {
        Solution00231 solution = new Solution00231();
        boolean result = solution.isPowerOfTwoBitCount(n);
        assertEquals(expected, result);
    }

}