package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00264Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void nthUglyNumber_PriorityQueue(int expected, int n) {
        assertEquals(expected, new Solution00264().nthUglyNumber_PriorityQueue(n));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void nthUglyNumber_Dp(int expected, int n) {
        assertEquals(expected, new Solution00264().nthUglyNumber_Dp(n));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(12, 10),
                Arguments.of(1, 1),
                Arguments.of(536870912, 1407)
        );
    }

}