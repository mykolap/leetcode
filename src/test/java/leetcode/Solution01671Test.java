package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01671Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumMountainRemovals(String numsStr, int expected) {
        Solution01671 solution01671 = new Solution01671();
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        assertEquals(expected, solution01671.minimumMountainRemovals(nums));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumMountainRemovalsDp(String numsStr, int expected) {
        Solution01671 solution01671 = new Solution01671();
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        assertEquals(expected, solution01671.minimumMountainRemovalsDp(nums));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,3,1]", 0),
                Arguments.of("[2,1,1,5,6,2,3,1]", 3)
        );
    }

}