package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00861Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void matrixScore(String gridStr, int expected) {
        int[][] grid = ArrayUtils.stringTo2DIntArray(gridStr);
        int result = new Solution00861().matrixScore(grid);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[0,0,1,1],[1,0,1,0],[1,1,0,0]]", 39),
                Arguments.of("[[0,1],[1,1]]", 5)
        );
    }

}