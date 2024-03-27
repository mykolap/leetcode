package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00713Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numSubarrayProductLessThanK(int[] nums, int k, int expected) {
        int result = new Solution00713().numSubarrayProductLessThanK(nums, k);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{10, 5, 2, 6}, 100, 8),
                Arguments.of(new int[]{1, 2, 3}, 0, 0),
                Arguments.of(new int[]{1, 2, 3}, 1, 0),
                Arguments.of(new int[]{1, 2, 3}, 2, 1),
                Arguments.of(new int[]{1, 2, 3}, 3, 3),
                Arguments.of(new int[]{1, 2, 3}, 4, 4)
        );
    }

}
