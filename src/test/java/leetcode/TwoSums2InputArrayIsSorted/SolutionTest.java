package leetcode.TwoSums2InputArrayIsSorted;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    static Stream<Arguments> getTwoSumArgs() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
                Arguments.of(new int[]{2, 8, 11, 15}, 9, new int[]{}),
                Arguments.of(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 4}, 6, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("getTwoSumArgs")
    void twoSumBruteForce(int[] nums, int target, int[] expected) {
        assertArrayEquals(expected, new Solution().twoSumBruteForce(nums, target));
    }

    @ParameterizedTest
    @MethodSource("getTwoSumArgs")
    void twoSum(int[] nums, int target, int[] expected) {
        assertArrayEquals(expected, new Solution().twoSum(nums, target));
    }

}