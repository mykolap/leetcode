package leetcode.maxAreaOfIsland;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0695Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                }, 6),
                Arguments.of(new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0}
                }, 0),
                Arguments.of(new int[][]{{0}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxAreaOfIsland(int[][] grid, int expected) {
        int actual = new Solution0695().maxAreaOfIsland(grid);
        assertEquals(expected, actual);
    }
}