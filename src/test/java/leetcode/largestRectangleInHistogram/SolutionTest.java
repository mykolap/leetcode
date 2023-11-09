package leetcode.largestRectangleInHistogram;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getLargestRectangleAreaArgs() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 5, 6, 2, 3}, 10),
                Arguments.of(new int[]{2, 4}, 4),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 1}, 2),
                Arguments.of(new int[]{2, 1, 2}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("getLargestRectangleAreaArgs")
    void largestRectangleArea(int[] heights, int expected) {
        assertEquals(expected, new Solution().largestRectangleArea(heights));
    }

    @ParameterizedTest
    @MethodSource("getLargestRectangleAreaArgs")
    void largestRectangleAreaBruteForce(int[] heights, int expected) {
        assertEquals(expected, new Solution().largestRectangleAreaBruteForce(heights));
    }

}