package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01863Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void subsetXORSum(String numStr, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numStr);
        assertEquals(expected, new Solution01863().subsetXORSum(nums));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void subsetXORSumRecursion(String numStr, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numStr);
        assertEquals(expected, new Solution01863().subsetXORSumRecursion(nums));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,3]", 6),
                Arguments.of("[5,1,6]", 28),
                Arguments.of("[3,4,5,6,7,8]", 480)
        );
    }

}