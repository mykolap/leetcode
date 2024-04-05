package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03095Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumSubarrayLength(int[] nums, int k, int expected) {
        int result = new Solution03095().minimumSubarrayLength(nums, k);
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
                        new int[]{1, 2, 3}, 100, -1)
        );
    }

}