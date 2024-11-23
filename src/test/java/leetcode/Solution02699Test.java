package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02699Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void modifiedGraphEdges(int n, String edgesStr, int source, int destination, int target, String expectedStr) {
        int[][] edges = ArrayUtils.stringToInt2DArray(edgesStr);
        var actual = new Solution02699().modifiedGraphEdges(n, edges, source, destination, target);
        assertThat(Arrays.deepToString(actual).replace(" ", "")).isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(5,
                        "[[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]]",
                        0, 1, 5,
                        "[[4,1,1],[2,0,3],[0,3,3],[4,3,1]]"),
                Arguments.of(3,
                        "[[0,1,-1],[0,2,5]]",
                        0, 2, 6,
                        "[]"),
                Arguments.of(4,
                        "[[1,0,4],[1,2,3],[2,3,5],[0,3,-1]]",
                        0, 2, 6,
                        "[[1,0,4],[1,2,3],[2,3,5],[0,3,1]]")
        );
    }

}