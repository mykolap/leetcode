package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02461Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maximumSubarraySum(String numsStr, int k, long expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        long result = new Solution02461().maximumSubarraySum(nums, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,5,4,2,9,9,9]", 3, 15),
                Arguments.of("[4,4,4]", 3, 0)
        );
    }

}