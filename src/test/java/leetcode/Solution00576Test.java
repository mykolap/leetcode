package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00576Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(2, 2, 2, 0, 0, 6),
                Arguments.of(1, 3, 3, 0, 1, 12),
                Arguments.of(36, 5, 50, 15, 3, 390153306)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findPaths(int m, int n, int maxMove, int startRow, int startColumn, int expected) {
        int actual = new Solution00576().findPaths(m, n, maxMove, startRow, startColumn);
        assertEquals(expected, actual);
    }

}