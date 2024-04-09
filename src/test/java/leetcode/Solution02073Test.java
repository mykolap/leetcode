package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02073Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void timeRequiredToBuy(int[] tickets, int k, int expected) {
        int result = new Solution02073().timeRequiredToBuy(tickets, k);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void timeRequiredToBuyOptimized(int[] tickets, int k, int expected) {
        int result = new Solution02073().timeRequiredToBuyOptimized(tickets, k);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 2}, 2, 6),
                Arguments.of(new int[]{5, 1, 1, 1}, 0, 8)
        );
    }

}