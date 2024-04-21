package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01971Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void validPath(int n, int[][] edges, int start, int end, boolean expected) {
        boolean actual = new Solution01971().validPath(n, edges, start, end);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void validPathUf(int n, int[][] edges, int start, int end, boolean expected) {
        boolean actual = new Solution01971().validPathUf(n, edges, start, end);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void validPathSpread(int n, int[][] edges, int start, int end, boolean expected) {
        boolean actual = new Solution01971().validPathSpread(n, edges, start, end);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(3,
                        new int[][]{{0, 1}, {1, 2}, {2, 0}},
                        0, 2, true),
                Arguments.of(6,
                        new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}},
                        0, 5, false),
                Arguments.of(1,
                        new int[][]{},
                        0, 0, true),
                Arguments.of(2,
                        new int[][]{},
                        0, 1, false)

        );
    }
}