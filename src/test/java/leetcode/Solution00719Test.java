package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00719Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void smallestDistancePair(String numsStr, int k, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        final int result = new Solution00719().smallestDistancePair(nums, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,3,1]", 1, 0),
                Arguments.of("[1,1,1]", 2, 0),
                Arguments.of("[1,6,1]", 3, 5)
        );
    }

}