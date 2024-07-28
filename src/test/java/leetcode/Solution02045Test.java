package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02045Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void secondMinimum(int n, String edgesStr, int time, int change, int expected) {
        int[][] edges = ArrayUtils.stringTo2DIntArray(edgesStr);

        int result = new Solution02045().secondMinimum(n, edges, time, change);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(5, "[[1,2],[1,3],[1,4],[3,4],[4,5]]", 3, 5, 13),
                Arguments.of(2, "[[1,2]]", 3, 2, 11)
        );
    }

}