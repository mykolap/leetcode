package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01248Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numberOfSubarrays(String numsStr, int k, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int result = new Solution01248().numberOfSubarrays(nums, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,1,2,1,1]", 3, 2),
                Arguments.of("[2,4,6]", 1, 0),
                Arguments.of("[2,2,2,1,2,2,1,2,2,2]", 2, 16)
        );
    }

}