package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00834Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sumOfDistancesInTree(int n, int[][] edges, int[] expected) {
        int[] result = new Solution00834().sumOfDistancesInTree(n, edges);
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sumOfDistancesInTree2(int n, int[][] edges, int[] expected) {
        int[] result = new Solution00834().sumOfDistancesInTree2(n, edges);
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(6, new int[][]{
                                {0, 1},
                                {0, 2},
                                {2, 3},
                                {2, 4},
                                {2, 5}
                        },
                        new int[]{8, 12, 6, 10, 10, 10}),
                Arguments.of(1, new int[][]{},
                        new int[]{0})
        );
    }

}