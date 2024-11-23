package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02684Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxMoves(String gridStr, int expected) {
        Solution02684 solution02684 = new Solution02684();
        int[][] grid = ArrayUtils.stringToInt2DArray(gridStr);
        int actual = solution02684.maxMoves(grid);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]", 3),
                Arguments.of("[[3,2,4],[2,1,9],[1,1,7]]", 0)
        );
    }

}