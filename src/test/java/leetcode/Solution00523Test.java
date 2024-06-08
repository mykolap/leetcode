package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00523Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void checkSubarraySum(String numsStr, int k, boolean expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        var solution = new Solution00523();
        var result = solution.checkSubarraySum(nums, k);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void checkSubarraySumBruteforce(String numsStr, int k, boolean expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        var solution = new Solution00523();
        var result = solution.checkSubarraySumBruteforce(nums, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3]", 3, true),
                Arguments.of("[0,0,3]", 50, true),
                Arguments.of("[23, 2, 4, 6, 7]", 6, true),
                Arguments.of("[23, 2, 6, 4, 7]", 6, true),
                Arguments.of("[23, 2, 6, 4, 7]", 13, false),
                Arguments.of("[13, 1, 2]", 3, true),
                Arguments.of("[11, 12, 2, 8]", 10, true),
                Arguments.of("[11, 12, 10]", 10, false)
        );
    }

}