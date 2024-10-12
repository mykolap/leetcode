package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02406Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minGroups(String intervalsStr, int expected) {
        int[][] intervals = ArrayUtils.stringTo2DIntArray(intervalsStr);
        int result = new Solution02406().minGroups(intervals);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[5,10],[6,8],[1,5],[2,3],[1,10]]", 3),
                Arguments.of("[[1,3],[5,6],[8,10],[11,13]]", 1)
        );
    }

}