package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00994Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void orangesRotting(int[][] grid, int expected) {
        final int actual = new Solution00994().orangesRotting(grid);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.arguments(new int[][]{
                                {2, 1, 1},
                                {1, 1, 0},
                                {0, 1, 1}
                        },
                        4),
                Arguments.arguments(new int[][]{
                                {2, 1, 1},
                                {0, 1, 1},
                                {1, 0, 1}
                        },
                        -1),
                Arguments.arguments(new int[][]{
                                {1, 2}
                        },
                        1),
                Arguments.arguments(new int[][]{
                                {0, 2}
                        },
                        0)
        );
    }

}