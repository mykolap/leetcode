package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00931Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}, 13),
                Arguments.of(new int[][]{{-19, 57}, {-40, -5}}, -59),
                Arguments.of(new int[][]{{-48}}, -48)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minFallingPathSum(int[][] matrix, int expected) {
        int actual = Solution00931.minFallingPathSum(matrix);
        assertEquals(expected, actual);
    }

}