package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00239Test {

    static Stream<Arguments> getMaxSlidingWindowArgs() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1, -1}, 1, new int[]{1, -1}),
                Arguments.of(new int[]{9, 11}, 2, new int[]{11}),
                Arguments.of(new int[]{4, -2}, 2, new int[]{4}),
                Arguments.of(new int[]{1, 3, 1, 2, 0, 5}, 3, new int[]{3, 3, 2, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10}),
                Arguments.of(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 3, new int[]{10, 9, 8, 7, 6, 5, 4, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("getMaxSlidingWindowArgs")
    void maxSlidingWindow(int[] nums, int k, int[] expected) {
        Assertions.assertArrayEquals(expected, new Solution00239().maxSlidingWindow(nums, k));
    }

    @ParameterizedTest
    @MethodSource("getMaxSlidingWindowArgs")
    void maxSlidingWindowDeque(int[] nums, int k, int[] expected) {
        assertArrayEquals(expected, new Solution00239().maxSlidingWindowDeque(nums, k));
    }

}