package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00670Test {

    @ParameterizedTest
    @MethodSource
    void findShortestPath(int input, int expected) {
        Solution00670 solution00670 = new Solution00670();
        var actual = solution00670.maximumSwap(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> findShortestPath() {
        return Stream.of(
                Arguments.of(2736, 7236),
                Arguments.of(9973, 9973),
                Arguments.of(98368, 98863)
        );
    }

}