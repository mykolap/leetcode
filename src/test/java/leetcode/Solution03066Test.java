package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03066Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minOperationsDraft(int[] nums, int k, int expected) {
        final int actual = new Solution03066().minOperationsDraft(nums, k);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minOperations(int[] nums, int k, int expected) {
        final int actual = new Solution03066().minOperations(nums, k);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 11, 10, 1, 3},
                        10, 2
                ),
                Arguments.of(
                        new int[]{1, 1, 2, 4, 9},
                        20, 4
                ),
                Arguments.of(
                        new int[]{1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999},
                        1000000000, 2
                ),
                Arguments.of(new int[]{61, 81, 12, 29, 3, 96, 96, 28, 38, 71},
                        97, 7
                )
        );
    }

}