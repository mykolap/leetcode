package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02402Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void mostBooked(int n, int[][] meetings, int expected) {
        Solution02402 solution = new Solution02402();
        int result = solution.mostBooked(n, meetings);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void mostBooked2(int n, int[][] meetings, int expected) {
        Solution02402 solution = new Solution02402();
        int result = solution.mostBooked2(n, meetings);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(2, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}}, 0),
                Arguments.of(3, new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}}, 1)
        );
    }

}