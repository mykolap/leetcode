package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00463Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void islandPerimeter(int[][] grid, int expected) {
        int result = new Solution00463().islandPerimeter(grid);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}, 16),
                Arguments.of(new int[][]{{1}}, 4),
                Arguments.of(new int[][]{{1, 0}}, 4),
                Arguments.of(new int[][]{{1, 1}}, 6)
        );
    }

}