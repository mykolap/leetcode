package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01509Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minDifferenceSorting(String numsStr, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        assertEquals(expected, new Solution01509().minDifferenceSorting(nums));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minDifference(String numsStr, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        assertEquals(expected, new Solution01509().minDifference(nums));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[5,3,2,4]", 0),
                Arguments.of("[1,5,0,10,14]", 1),
                Arguments.of("[6,6,0,1,1,4,6]", 2),
                Arguments.of("[1,5,6,14,15]", 1)
        );
    }

}