package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01590Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minSubarray(String numsStr, int p, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int result = new Solution01590().minSubarray(nums, p);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[3,1,4,2]", 6, 1),
                Arguments.of("[6,3,5,2]", 9, 2),
                Arguments.of("[1,2,3]", 3, 0),
                Arguments.of("[1,2,3]", 7, -1),
                Arguments.of("[1000000000,1000000000,1000000000]", 3, 0),
                Arguments.of("[1]", 1, 0)
        );
    }

}