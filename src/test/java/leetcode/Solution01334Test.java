package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01334Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findTheCity(int n, String edgesStr, int distanceThreshold, int expected) {
        int[][] edges = ArrayUtils.stringTo2DIntArray(edgesStr);

        int result = new Solution01334().findTheCity(n, edges, distanceThreshold);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(4, "[[0,1,3],[1,2,1],[1,3,4],[2,3,1]]", 4, 3),
                Arguments.of(5, "[[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]]", 2, 0)
        );
    }

}