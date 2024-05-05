package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00213Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rob(int[] nums, int expected) {
        int result = new Solution00213().rob(nums);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void robOptimized(int[] nums, int expected) {
        int result = new Solution00213().robOptimized(nums);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 2}, 3),
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 2}, 2),
                Arguments.of(new int[]{1, 2, 3}, 3)
        );
    }

}