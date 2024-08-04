package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01508Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rangeSum(String numsStr, int n, int left, int right, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int actual = new Solution01508().rangeSum(nums, n, left, right);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rangeSumMinHeap(String numsStr, int n, int left, int right, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int actual = new Solution01508().rangeSumMinHeap(nums, n, left, right);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3,4]", 4, 1, 5, 13),
                Arguments.of("[1,2,3,4]", 4, 3, 4, 6),
                Arguments.of("[1,2,3,4]", 4, 1, 10, 50)
        );
    }

}