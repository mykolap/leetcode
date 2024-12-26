package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00494Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findTargetSumWays(String numsStr, int target, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int actual = new Solution00494().findTargetSumWays(nums, target);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findTargetSumWaysDp(String numsStr, int target, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int actual = new Solution00494().findTargetSumWaysDp(nums, target);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,1,1,1,1]", 3, 5),
                Arguments.of("[1]", 1, 1)
        );
    }

}