package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01438Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void longestSubarray(String numsStr, int limit, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        assertEquals(expected, new Solution01438().longestSubarray(nums, limit));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void longestSubarrayOptimized(String numsStr, int limit, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        assertEquals(expected, new Solution01438().longestSubarrayOptimized(nums, limit));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[8,2,4,7]", 4, 2),
                Arguments.of("[10,1,2,4,7,2]", 5, 4),
                Arguments.of("[4,2,2,2,4,4,2,2]", 0, 3)
        );
    }

}