package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01463Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{
                                {3, 1, 1},
                                {2, 5, 1},
                                {1, 5, 5},
                                {2, 1, 1}
                        },
                        24),
                Arguments.of(new int[][]{
                                {1, 0, 0, 0, 0, 0, 1},
                                {2, 0, 0, 0, 0, 3, 0},
                                {2, 0, 9, 0, 0, 0, 0},
                                {0, 3, 0, 5, 4, 0, 0},
                                {1, 0, 2, 3, 0, 0, 6}
                        },
                        28)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void cherryPickupDp3d(int[][] grid, int expected) {
        int result = new Solution01463().cherryPickupDp3d(grid);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void cherryPickupDp3dOptimized(int[][] grid, int expected) {
        int result = new Solution01463().cherryPickupDp3dOptimized(grid);
        assertEquals(expected, result);
    }

}