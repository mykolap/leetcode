package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02257Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countUnguarded(int m, int n, String guardsStr, String wallsStr, int expected) {
        int[][] guards = ArrayUtils.stringToInt2DArray(guardsStr);
        int[][] walls = ArrayUtils.stringToInt2DArray(wallsStr);
        int result = new Solution02257().countUnguarded(m, n, guards, walls);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(4, 6, "[[0,0],[1,1],[2,3]]", "[[0,1],[2,2],[1,4]]", 7),
                Arguments.of(3, 3, "[[1,1]]", "[[0,1],[1,0],[2,1],[1,2]]", 4)
        );
    }

}