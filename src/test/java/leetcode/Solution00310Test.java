package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00310Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findMinHeightTrees(int n, int[][] edges, List<Integer> expected) {
        Solution00310 underTest = new Solution00310();
        assertEquals(expected, underTest.findMinHeightTrees(n, edges));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findMinHeightTreesMoreEfficient(int n, int[][] edges, List<Integer> expected) {
        Solution00310 underTest = new Solution00310();
        assertEquals(expected, underTest.findMinHeightTreesMoreEfficient(n, edges));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(4,
                        new int[][]{{1, 0}, {1, 2}, {1, 3}},
                        List.of(1)),
                Arguments.of(6,
                        new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}},
                        List.of(3, 4)),
                Arguments.of(1,
                        new int[][]{},
                        List.of(0)),
                Arguments.of(2,
                        new int[][]{{0, 1}},
                        List.of(0, 1))
        );
    }
}