package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00947Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void removeStones(String stonesStr, int expected) {
        int[][] stones = ArrayUtils.stringTo2DIntArray(stonesStr);
        int result = new Solution00947().removeStones(stones);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]", 5),
                Arguments.of("[[0,0],[0,2],[1,1],[2,0],[2,2]]", 3),
                Arguments.of("[[0,0]]", 0)
        );
    }

}