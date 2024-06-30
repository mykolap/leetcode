package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01579Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxNumEdgesToRemove(int n, String edgesStr, int expected) {
        int[][] edges = ArrayUtils.stringTo2DIntArray(edgesStr);
        int actual = new Solution01579().maxNumEdgesToRemove(n, edges);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(4, "[[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]", 2),
                Arguments.of(4, "[[3,1,2],[3,2,3],[1,1,4],[2,1,4]]", 0),
                Arguments.of(4, "[[3,2,3],[1,1,2],[2,3,4]]", -1)
        );
    }

}