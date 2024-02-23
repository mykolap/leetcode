package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00787Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findCheapestPrice(int n, int[][] flights, int src, int dst, int k, int expected) {
        final int actual = new Solution00787().findCheapestPrice(n, flights, src, dst, k);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(4,
                        new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}},
                        0, 3, 1, 700),
                Arguments.of(3,
                        new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                        0, 2, 1, 200),
                Arguments.of(3,
                        new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                        0, 2, 0, 500)
        );
    }
}