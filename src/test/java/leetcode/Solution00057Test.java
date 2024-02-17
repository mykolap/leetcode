package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00057Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 3}, {6, 9}},
                        new int[]{2, 5},
                        new int[][]{{1, 5}, {6, 9}}
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                        new int[]{4, 8},
                        new int[][]{{1, 2}, {3, 10}, {12, 16}}
                ),
                Arguments.of(
                        new int[][]{},
                        new int[]{5, 7},
                        new int[][]{{5, 7}}
                ),
                Arguments.of(
                        new int[][]{{1, 5}},
                        new int[]{2, 3},
                        new int[][]{{1, 5}}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void insert(int[][] intervals, int[] newInterval, int[][] expected) {
        assertArrayEquals(expected, new Solution00057().insert(intervals, newInterval));
    }

}