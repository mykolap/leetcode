package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00198Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                Arguments.of(new int[]{2, 7, 9, 3, 1}, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rob(int[] nums, int expected) {
        assertEquals(expected, new Solution00198().rob(nums));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void robDp(int[] nums, int expected) {
        assertEquals(expected, new Solution00198().robDp(nums));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void robBruteForce(int[] nums, int expected) {
        assertEquals(expected, new Solution00198().robBruteForce(nums));
    }

}