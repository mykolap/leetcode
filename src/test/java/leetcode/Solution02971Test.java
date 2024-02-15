package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02971Test {

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{5, 5, 5}, 15),
                Arguments.of(new int[]{1, 12, 1, 2, 5, 50, 3}, 12),
                Arguments.of(new int[]{5, 5, 50}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void largestPerimeter(int[] nums, long expected) {
        long actual = new Solution02971().largestPerimeter(nums);
        assertEquals(expected, actual);
    }

}