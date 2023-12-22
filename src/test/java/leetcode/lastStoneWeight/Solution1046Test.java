package leetcode.lastStoneWeight;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution1046Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 4, 1, 8, 1}, 1),
                Arguments.of(new int[]{2, 2}, 0),
                Arguments.of(new int[]{2, 2, 2}, 2),
                Arguments.of(new int[]{1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void lastStoneWeight(int[] stones, int expected) {
        assertEquals(expected, new Solution1046().lastStoneWeight(stones));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void lastStoneWeightFirstApproach(int[] stones, int expected) {
        assertEquals(expected, new Solution1046().lastStoneWeightFirstApproach(stones));
    }

}