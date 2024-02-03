package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01043Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 15, 7, 9, 2, 5, 10}, 3, 84),
                Arguments.of(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4, 83),
                Arguments.of(new int[]{1}, 1, 1),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 3, 19)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxSumAfterPartitioning(int[] arr, int k, int expected) {
        assertEquals(expected, new Solution01043().maxSumAfterPartitioning(arr, k));
    }
}