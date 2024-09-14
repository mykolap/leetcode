package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02419Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void longestSubarray(String numsStr, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int actual = new Solution02419().longestSubarray(nums);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3,3,2,2]", 2),
                Arguments.of("[1,2,3,4]", 1),
                Arguments.of("[96317,96317,96317,96317,96317,96317,96317,96317,96317,279979]", 1)
        );
    }

}