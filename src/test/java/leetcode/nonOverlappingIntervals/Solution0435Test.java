package leetcode.nonOverlappingIntervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0435Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}, 1),
                Arguments.of(new int[][]{{1, 2}, {1, 2}, {1, 2}}, 2),
                Arguments.of(new int[][]{{1, 2}, {2, 3}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void eraseOverlapIntervalsSortByEnd(int[][] intervals, int expected) {
        int actual = new Solution0435().eraseOverlapIntervalsSortByEnd(intervals);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void eraseOverlapIntervalsSortByStart(int[][] intervals, int expected) {
        int actual = new Solution0435().eraseOverlapIntervalsSortByStart(intervals);
        assertEquals(expected, actual);
    }
}