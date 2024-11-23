package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01942Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void smallestChair(String timesStr, int targetFriend, int expected) {
        int[][] times = ArrayUtils.stringToInt2DArray(timesStr);
        int actual = new Solution01942().smallestChair(times, targetFriend);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,4],[2,3],[4,6]]", 1, 1),
                Arguments.of("[[3,10],[1,5],[2,6]]", 0, 2),
                Arguments.of("[[1,4],[2,3],[4,6]]", 2, 0)
        );
    }

}