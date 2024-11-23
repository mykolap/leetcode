package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00840Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numMagicSquaresInside(String gridStr, int expected) {
        int[][] grid = ArrayUtils.stringToInt2DArray(gridStr);
        int actual = new Solution00840().numMagicSquaresInside(grid);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[4,3,8,4],[9,5,1,9],[2,7,6,2]]", 1),
                Arguments.of("[[8]]", 0),
                Arguments.of("[[5,5,5],[5,5,5],[5,5,5]]", 0)
        );
    }

}