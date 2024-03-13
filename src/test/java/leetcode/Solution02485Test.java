package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02485Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void pivotInteger(int n, int expected) {
        int result = new Solution02485().pivotInteger(n);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void pivotIntegerImproved(int n, int expected) {
        int result = new Solution02485().pivotIntegerImproved(n);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, -1),
                Arguments.of(3, -1),
                Arguments.of(4, -1),
                Arguments.of(5, -1),
                Arguments.of(6, -1),
                Arguments.of(7, -1),
                Arguments.of(8, 6),
                Arguments.of(9, -1),
                Arguments.of(10, -1),
                Arguments.of(48, -1),
                Arguments.of(49, 35),
                Arguments.of(50, -1)

        );
    }

}