package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02962Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countSubarrays(int[] nums, int k, long expected) {
        long result = new Solution02962().countSubarrays(nums, k);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 3, 2, 3, 3},
                        2, 6L),
                Arguments.of(
                        new int[]{1, 4, 2, 1},
                        3, 0L)
        );
    }

}