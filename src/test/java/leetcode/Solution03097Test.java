package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03097Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumSubarrayLength(int[] nums, int k, int expected) {
        int result = new Solution03097().minimumSubarrayLength(nums, k);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumSubarrayLengthOptimized(int[] nums, int k, int expected) {
        int result = new Solution03097().minimumSubarrayLengthOptimized(nums, k);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3}, 2, 1),
                Arguments.of(
                        new int[]{2, 1, 8}, 10, 3),
                Arguments.of(
                        new int[]{1, 2}, 0, 1),
                Arguments.of(
                        new int[]{1, 2, 3}, 100, -1),
                Arguments.of(
                        new int[]{1, 2, 32, 21}, 55, 3)
        );
    }

}