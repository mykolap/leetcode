package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02290Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumObstacles(String gridStr, int expected) {
        int[][] grid = ArrayUtils.stringToInt2DArray(gridStr);
        int result = new Solution02290().minimumObstacles(grid);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[0,1,1],[1,1,0],[1,1,0]]", 2),
                Arguments.of("[[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]", 0)
        );
    }

}