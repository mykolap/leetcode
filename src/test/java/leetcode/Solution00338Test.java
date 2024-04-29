package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00338Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countBits(int n, int[] expected) {
        int[] result = new Solution00338().countBits(n);
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countBitsClear(int n, int[] expected) {
        int[] result = new Solution00338().countBitsClear(n);
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(2, new int[]{0, 1, 1}),
                Arguments.of(5, new int[]{0, 1, 1, 2, 1, 2}),
                Arguments.of(0, new int[]{0}),
                Arguments.of(1, new int[]{0, 1}),
                Arguments.of(3, new int[]{0, 1, 1, 2})
        );
    }
}