package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02444Test {

    /*
    Example 1:

    Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
    Output: 2
    Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
    Example 2:

    Input: nums = [1,1,1,1], minK = 1, maxK = 1
    Output: 10
    Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.

     */

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countSubarrays(int[] nums, int minK, int maxK, long expected) {
        long result = new Solution02444().countSubarrays(nums, minK, maxK);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 2, 7, 5},
                        1, 5, 2),
                Arguments.of(new int[]{1, 1, 1, 1},
                        1, 1, 10)
        );
    }

}