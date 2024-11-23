package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01219Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void getMaximumGold(String gridStr, int expected) {
        int[][] grid = ArrayUtils.stringToInt2DArray(gridStr);
        int result = new Solution01219().getMaximumGold(grid);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[0,6,0],[5,8,7],[0,9,0]]", 24),
                Arguments.of("[[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]", 28)
        );
    }

}