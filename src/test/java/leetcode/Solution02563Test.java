package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02563Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countFairPairs(String numsStr, int lower, int upper, long expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        long result = new Solution02563().countFairPairs(nums, lower, upper);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[0,1,7,4,4,5]", 3, 6, 6L),
                Arguments.of("[1,7,9,2,5]", 11, 11, 1)
        );
    }

}