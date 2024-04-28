package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03128Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numberOfRightTriangles(int[][] grid, long expected) {
        long result = new Solution03128().numberOfRightTriangles(grid);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {0, 1, 0},
                        {0, 1, 1},
                        {0, 1, 0}
                }, 2L),
                Arguments.of(new int[][]{
                        {1, 0, 0, 0},
                        {0, 1, 0, 1},
                        {1, 0, 0, 0}
                }, 0L),
                Arguments.of(new int[][]{
                        {1, 0, 1},
                        {1, 0, 0},
                        {1, 0, 0}}, 2L),
                Arguments.of(new int[][]{
                        {0, 0},
                        {0, 1},
                        {1, 1}}, 1L)

        );
    }
}