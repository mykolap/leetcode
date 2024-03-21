package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution3080Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void unmarkedSumArray(int[] nums, int[][] queries, long[] expected) {
        long[] result = new Solution3080().unmarkedSumArray(nums, queries);
        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return java.util.stream.Stream.of(
                Arguments.of(
                        new int[]{1, 2, 2, 1, 2, 3, 1},
                        new int[][]{{1, 2}, {3, 3}, {4, 2}},
                        new long[]{8, 3, 0}
                ),
                Arguments.of(
                        new int[]{1, 4, 2, 3},
                        new int[][]{{0, 1}},
                        new long[]{7}
                )
        );
    }
}