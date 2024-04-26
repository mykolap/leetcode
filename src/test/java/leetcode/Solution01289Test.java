package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01289Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minFallingPathSum(int[][] grid, int expected) {
        assertEquals(expected, new Solution01289().minFallingPathSum(grid));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}, 12),
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 13),
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, 5),
                Arguments.of(new int[][]{{1}}, 1),
                Arguments.of(new int[][]{{1, 99, 99}, {0, 2, 1}, {99, 99, 4}}, 7)
        );
    }

}