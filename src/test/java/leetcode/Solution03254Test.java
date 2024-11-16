package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution03254Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void resultsArray(String numsStr, int k, String expectedStr) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int[] actual = new Solution03254().resultsArray(nums, k);
        assertThat(ArrayUtils.intArrayToString(actual))
                .isEqualTo(expectedStr);
    }

    /*
    Example 1:

Input: nums = [1,2,3,4,3,2,5], k = 3

Output: [3,4,-1,-1,-1]

Explanation:

There are 5 subarrays of nums of size 3:

[1, 2, 3] with the maximum element 3.
[2, 3, 4] with the maximum element 4.
[3, 4, 3] whose elements are not consecutive.
[4, 3, 2] whose elements are not sorted.
[3, 2, 5] whose elements are not consecutive.
Example 2:

Input: nums = [2,2,2,2,2], k = 4

Output: [-1,-1]

Example 3:

Input: nums = [3,2,3,2,3,2], k = 2

Output: [-1,3,-1,3,-1]


     */
    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3,4,3,2,5]", 3, "[3,4,-1,-1,-1]"),
                Arguments.of("[2,2,2,2,2]", 4, "[-1,-1]"),
                Arguments.of("[3,2,3,2,3,2]", 2, "[-1,3,-1,3,-1]")
        );
    }

}