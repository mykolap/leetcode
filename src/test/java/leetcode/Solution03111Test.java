package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03111Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minRectanglesToCoverPoints(int[][] points, int maxPoints, int expected) {
        int result = new Solution03111().minRectanglesToCoverPoints(points, maxPoints);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{2, 1}, {1, 0}, {1, 4}, {1, 8}, {3, 5}, {4, 6}},
                        1, 2),
                Arguments.of(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}},
                        2, 3),
                Arguments.of(new int[][]{{2, 3}, {1, 2}},
                        0, 2),
                Arguments.of(new int[][]{{2, 1}, {1, 3}},
                        1, 1),
                Arguments.of(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}},
                        2, 3)
        );
    }

}