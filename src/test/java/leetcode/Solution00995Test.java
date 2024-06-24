package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00995Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minKBitFlips(String numsStr, int k, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        assertEquals(expected, new Solution00995().minKBitFlips(nums, k));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minKBitFlipsQueue(String numsStr, int k, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        assertEquals(expected, new Solution00995().minKBitFlipsQueue(nums, k));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[0,1,0]", 1, 2),
                Arguments.of("[1,1,0]", 2, -1),
                Arguments.of("[0,0,0,1,0,1,1,0]", 3, 3)
        );
    }

}