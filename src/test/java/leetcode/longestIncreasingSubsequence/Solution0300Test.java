package leetcode.longestIncreasingSubsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0300Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4),
                Arguments.arguments(new int[]{0, 1, 0, 3, 2, 3}, 4),
                Arguments.arguments(new int[]{7, 7, 7, 7, 7, 7, 7}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void lengthOfLIS(int[] nums, int expected) {
        final int actual = new Solution0300().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

}