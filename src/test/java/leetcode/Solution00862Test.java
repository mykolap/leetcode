package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00862Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void shortestSubarray(String numsStr, int k, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        assertEquals(expected, new Solution00862().shortestSubarray(nums, k));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1]", 1, 1),
                Arguments.of("[1,2]", 4, -1),
                Arguments.of("[2,-1,2]", 3, 3),
                Arguments.of("[17,85,93,-45,-21]", 150, 2)
        );
    }

}