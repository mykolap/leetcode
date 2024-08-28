package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01905Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countSubIslands(String grid1Str, String grid2Str, int expected) {
        int[][] grid1 = ArrayUtils.stringTo2DIntArray(grid1Str);
        int[][] grid2 = ArrayUtils.stringTo2DIntArray(grid2Str);
        int result = new Solution01905().countSubIslands(grid1, grid2);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]",
                        "[[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]",
                        3)
        );
    }

}