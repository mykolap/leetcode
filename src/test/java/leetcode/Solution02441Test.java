package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02441Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findMaxKFirstApproach(int[] nums, int expected) {
        Solution02441 solution = new Solution02441();
        int output = solution.findMaxKFirstApproach(nums);
        assertEquals(expected, output);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findMaxK(int[] nums, int expected) {
        Solution02441 solution = new Solution02441();
        int output = solution.findMaxK(nums);
        assertEquals(expected, output);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{-1, 2, -3, 3}, 3),
                Arguments.of(new int[]{-1, 10, 6, 7, -7, 1}, 7),
                Arguments.of(new int[]{-10, 8, 6, 7, -2, -3}, -1),
                Arguments.of(new int[]{14, 33, 40, -33, 8, -24, -42, 30, -18, -34}, 33)
        );
    }
}