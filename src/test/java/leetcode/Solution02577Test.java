package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02577Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumTime(String gridStr, int expected) {
        int[][] grid = ArrayUtils.stringToInt2DArray(gridStr);
        int result = new Solution02577().minimumTime(grid);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[0,1,3,2],[5,1,2,5],[4,3,8,6]]", 7),
                Arguments.of("[[0,2,4],[3,2,1],[1,0,4]]", -1)
        );
    }

}