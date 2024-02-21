package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00128Test {

    static Stream<Arguments> getLongestConsecutiveArgs() {
        return Stream.of(
                Arguments.of(new int[]{100, 4, 200, 1, 3, 2}, 4),
                Arguments.of(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("getLongestConsecutiveArgs")
    void longestConsecutive(int[] nums, int expected) {
        assertEquals(expected, new Solution00128().longestConsecutive(nums));
    }

    @ParameterizedTest
    @MethodSource("getLongestConsecutiveArgs")
    void longestConsecutiveSorting(int[] nums, int expected) {
        assertEquals(expected, new Solution00128().longestConsecutiveSorting(nums));
    }

}