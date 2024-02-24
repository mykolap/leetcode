package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00053Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{-2, 1, -3, 4, -1,
                        2, 1, -5, 4}, 6),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{5, 4, -1, 7, 8}, 23),
                Arguments.of(new int[]{-1}, -1),
                Arguments.of(new int[]{-1, -2, -3, 0}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxSubArray(int[] nums, int expected) {
        assertEquals(expected, new Solution00053().maxSubArray(nums));
    }

}