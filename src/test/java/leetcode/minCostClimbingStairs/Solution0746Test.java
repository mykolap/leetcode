package leetcode.minCostClimbingStairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0746Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{10, 15, 20}, 15),
                Arguments.of(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6),
                Arguments.of(new int[]{0, 0, 0, 1}, 0),
                Arguments.of(new int[]{0, 0, 1, 0}, 0),
                Arguments.of(new int[]{0, 1, 0, 0}, 0),
                Arguments.of(new int[]{1, 0, 0, 0}, 0),
                Arguments.of(new int[]{0, 0, 0, 0}, 0),
                Arguments.of(new int[]{0, 0, 0}, 0),
                Arguments.of(new int[]{0, 0}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minCostClimbingStairs(int[] cost, int expected) {
        assertEquals(expected, new Solution0746().minCostClimbingStairs(cost));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minCostClimbingStairsFirstApproach(int[] cost, int expected) {
        assertEquals(expected, new Solution0746().minCostClimbingStairsFirstApproach(cost));
    }

}