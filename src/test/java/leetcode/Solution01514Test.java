package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01514Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxProbability(int n, String edgesStr, String succProbStr, int start_node, int end_node, double expected) {
        int[][] edges = ArrayUtils.stringTo2DIntArray(edgesStr);
        double[] succProb = ArrayUtils.stringToDoubleArray(succProbStr);
        double result = new Solution01514().maxProbabilityTLE(n, edges, succProb, start_node, end_node);
        assertEquals(expected, result, 1e-5);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxProbabilityGreedyDijkstra(int n, String edgesStr, String succProbStr, int start_node, int end_node, double expected) {
        int[][] edges = ArrayUtils.stringTo2DIntArray(edgesStr);
        double[] succProb = ArrayUtils.stringToDoubleArray(succProbStr);
        double result = new Solution01514().maxProbabilityGreedyDijkstra(n, edges, succProb, start_node, end_node);
        assertEquals(expected, result, 1e-5);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(3, "[[0,1],[1,2],[0,2]]", "[0.5,0.5,0.2]", 0, 2, 0.25),
                Arguments.of(3, "[[0,1],[1,2],[0,2]]", "[0.5,0.5,0.3]", 0, 2, 0.3),
                Arguments.of(3, "[[0,1]]", "[0.5]", 0, 2, 0),
                Arguments.of(3, "[[0,1]]", "[0.5]", 0, 1, 0.5)
        );
    }

}