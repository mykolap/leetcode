package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01937Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxPoints(String pointsStr, long expected) {
        int[][] points = ArrayUtils.stringTo2DIntArray(pointsStr);
        final long result = new Solution01937().maxPoints(points);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxPoints_TLE(String pointsStr, long expected) {
        int[][] points = ArrayUtils.stringTo2DIntArray(pointsStr);
        final long result = new Solution01937().maxPoints_TLE(points);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,2,3],[1,5,1],[3,1,1]]", 9),
                Arguments.of("[[1,5],[2,3],[4,2]]", 11)
        );
    }

}