package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02463Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumTotalDistance(String robotStr, String factoryStr, long expected) {
        Solution02463 solution = new Solution02463();
        List<Integer> robot = ArrayUtils.stringToIntList(robotStr);
        int[][] factory = ArrayUtils.stringToInt2DArray(factoryStr);
        var actual = solution.minimumTotalDistance(robot, factory);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumTotalDistance2(String robotStr, String factoryStr, long expected) {
        Solution02463 solution = new Solution02463();
        List<Integer> robot = ArrayUtils.stringToIntList(robotStr);
        int[][] factory = ArrayUtils.stringToInt2DArray(factoryStr);
        var actual = solution.minimumTotalDistance2(robot, factory);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[0,4,6]", "[[2,2],[6,2]]", 4L),
                Arguments.of("[1,-1]", "[[-2,1],[2,1]]", 2L)
        );
    }

}