package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01368Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minCost(String gridStr, int expected) {
        int[][] grid = ArrayUtils.stringToInt2DArray(gridStr);
        int result = new Solution01368().minCost(grid);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]", 3),
                Arguments.of("[[1,1,3],[3,2,2],[1,1,4]]", 0),
                Arguments.of("[[1,2],[4,3]]", 1)
        );
    }

}