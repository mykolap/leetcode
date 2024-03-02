package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00977Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sortedSquares(int[] nums, int[] expected) {
        int[] result = new Solution00977().sortedSquares(nums);
        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{-4, -1, 0, 3, 10}, new int[]{0, 1, 9, 16, 100}),
                Arguments.of(new int[]{-7, -3, 2, 3, 11}, new int[]{4, 9, 9, 49, 121}),
                Arguments.of(new int[]{2}, new int[]{4}),
                Arguments.of(new int[]{1, 1}, new int[]{1, 1}),
                Arguments.of(new int[]{-1, 1}, new int[]{1, 1}),
                Arguments.of(new int[]{-2, 1}, new int[]{1, 4}),
                Arguments.of(new int[]{-1, 2}, new int[]{1, 4})
        );
    }

}