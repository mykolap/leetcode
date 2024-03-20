package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00621Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void leastInterval(char[] tasks, int n, int expected) {
        int result = new Solution00621().leastInterval(tasks, n);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2, 8
                ),
                Arguments.of(
                        new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0, 6
                ),
                Arguments.of(
                        new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3, 10
                ),
                Arguments.of(
                        new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1, 6
                ),
                Arguments.of(
                        new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2, 16
                )
        );
    }
}