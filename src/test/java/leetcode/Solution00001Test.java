package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00001Test {

    static Stream<Arguments> getTwoSumArgs() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{2, 8, 11, 15}, 9, new int[]{}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
                Arguments.of(new int[]{3, 4}, 6, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("getTwoSumArgs")
    void twoSumBruteForce(int[] nums, int target, int[] expected) {
        Assertions.assertArrayEquals(expected, new Solution00001().twoSumBruteForce(nums, target));
    }

    @ParameterizedTest
    @MethodSource("getTwoSumArgs")
    void twoSum(int[] nums, int target, int[] expected) {
        assertArrayEquals(expected, new Solution00001().twoSum(nums, target));
    }

}