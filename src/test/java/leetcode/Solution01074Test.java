package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01074Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}},
                        0, 4),
                Arguments.of(new int[][]{{1, -1}, {-1, 1}},
                        0, 5),
                Arguments.of(new int[][]{{904}},
                        0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numSubmatrixSumTarget(int[][] matrix, int target, int expected) {
        int actual = new Solution01074().numSubmatrixSumTarget(matrix, target);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numSubmatrixSumTargetOptimized(int[][] matrix, int target, int expected) {
        int actual = new Solution01074().numSubmatrixSumTargetOptimized(matrix, target);
        assertEquals(expected, actual);
    }


}