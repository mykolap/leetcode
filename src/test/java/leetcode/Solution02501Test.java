package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02501Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void longestSquareStreak(String numsStr, int expected) {
        Solution02501 solution02501 = new Solution02501();
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        var actual = solution02501.longestSquareStreak(nums);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[4,3,6,16,8,2]", 3),
                Arguments.of("[2,3,5,6,7]", -1)
        );
    }

}