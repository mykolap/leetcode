package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00930Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numSubarraysWithSum(int[] nums, int goal, int expected) {
        int result = new Solution00930().numSubarraysWithSum(nums, goal);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numSubarraysWithSumAlt(int[] nums, int goal, int expected) {
        int result = new Solution00930().numSubarraysWithSumAlt(nums, goal);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 1, 0, 1}, 2, 4),
                Arguments.of(new int[]{0, 0, 0, 0, 0}, 0, 15)
        );
    }

}