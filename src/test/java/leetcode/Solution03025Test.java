package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03025Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {2, 1}, {1, 2}}, 0),
                Arguments.of(new int[][]{{1, 1}, {2, 2}, {3, 3}}, 0),
                Arguments.of(new int[][]{{1, 2}, {2, 2}, {3, 3}}, 1),
                Arguments.of(new int[][]{{6, 2}, {4, 4}, {2, 6}}, 2),
                Arguments.of(new int[][]{{3, 1}, {1, 3}, {1, 1}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numberOfPairs(int[][] points, int expected) {
        assertEquals(expected, new Solution03025().numberOfPairs(points));
    }
}