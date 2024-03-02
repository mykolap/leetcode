package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00238Test {

    static Stream<Arguments> getProductExceptSelfArgs() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                Arguments.of(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("getProductExceptSelfArgs")
    void productExceptSelfBruteforce(int[] nums, int[] expected) {
        Assertions.assertArrayEquals(expected, new Solution00238().productExceptSelfBruteforce(nums));
    }

    @ParameterizedTest
    @MethodSource("getProductExceptSelfArgs")
    void productExceptSelf(int[] nums, int[] expected) {
        assertArrayEquals(expected, new Solution00238().productExceptSelf(nums));
    }

    @ParameterizedTest
    @MethodSource("getProductExceptSelfArgs")
    void productExceptSelf2Arrays(int[] nums, int[] expected) {
        assertArrayEquals(expected, new Solution00238().productExceptSelf2Arrays(nums));
    }

}