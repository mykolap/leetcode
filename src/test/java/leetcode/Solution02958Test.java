package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02958Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxSubarrayLength(int[] nums, int k, int expected) {
        int result = new Solution02958().maxSubarrayLength(nums, k);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxSubarrayLengthLessCode(int[] nums, int k, int expected) {
        int result = new Solution02958().maxSubarrayLengthLessCode(nums, k);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 1, 2, 3, 1, 2},
                        2, 6),
                Arguments.of(
                        new int[]{1, 2, 1, 2, 1, 2, 1, 2},
                        1, 2),
                Arguments.of(
                        new int[]{5, 5, 5, 5, 5, 5, 5},
                        4, 4),
                Arguments.of(
                        new int[]{1, 4, 4, 3},
                        1, 2)
        );
    }
}