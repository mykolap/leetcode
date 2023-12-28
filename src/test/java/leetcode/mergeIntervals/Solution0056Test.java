package leetcode.mergeIntervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution0056Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                        new int[][]{{1, 6}, {8, 10}, {15, 18}}),
                Arguments.of(new int[][]{{1, 4}, {4, 5}},
                        new int[][]{{1, 5}}),
                Arguments.of(new int[][]{{1, 4}, {0, 4}},
                        new int[][]{{0, 4}}),
                Arguments.of(new int[][]{{1, 4}, {0, 0}},
                        new int[][]{{0, 0}, {1, 4}}),
                Arguments.of(new int[][]{{1, 4}, {0, 2}, {3, 5}},
                        new int[][]{{0, 5}})
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void merge(int[][] intervals, int[][] expected) {
        int[][] actual = new Solution0056().merge(intervals);
        assertArrayEquals(expected, actual);
    }

}