package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00074Test {

    static Stream<Arguments> getSearchMatrixArgs() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}},
                        3, true),
                Arguments.of(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}},
                        13, false),
                Arguments.of(new int[][]{},
                        0, false),
                Arguments.of(new int[][]{{1}},
                        1, true),
                Arguments.of(new int[][]{{1}},
                        2, false)
        );
    }

    @ParameterizedTest
    @MethodSource("getSearchMatrixArgs")
    void searchMatrix(int[][] matrix, int target, boolean expected) {
        assertEquals(expected, new Solution00074().searchMatrix(matrix, target));
    }

}