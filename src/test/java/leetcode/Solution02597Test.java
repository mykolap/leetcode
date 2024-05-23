package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02597Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void beautifulSubsets(String numsStr, int k, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int result = new Solution02597().beautifulSubsets(nums, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[2,4,6]", 2, 4),
                Arguments.of("[1]", 1, 1)
        );
    }

}