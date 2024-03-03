package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03065Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minOperations(int[] nums, int k, int expected) {
        final int actual = new Solution03065().minOperations(nums, k);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 11, 10, 1, 3}, 10, 3),
                Arguments.of(new int[]{1, 1, 2, 4, 9}, 1, 0),
                Arguments.of(new int[]{1, 1, 2, 4, 9}, 9, 4)
        );
    }
}