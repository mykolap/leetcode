package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01568Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minDays(String gridStr, int expected) {
        int[][] grid = ArrayUtils.stringToInt2DArray(gridStr);
        assertEquals(expected, new Solution01568().minDays(grid));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[0,1,1,0],[0,1,1,0],[0,0,0,0]]", 2),
                Arguments.of("[[1,1]]", 2),
                Arguments.of("[[1,0,1,0]]", 0)
        );
    }

}