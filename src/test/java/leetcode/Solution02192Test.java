package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02192Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void getAncestors(int n, String edgesStr, String expectedStr) {
        int[][] edges = ArrayUtils.stringTo2DIntArray(edgesStr);
        final List<List<Integer>> ancestors = new Solution02192().getAncestors(n, edges);
        assertThat(ArrayUtils.listOfListsToString(ancestors))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(8, "[[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]",
                        "[[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]"),
                Arguments.of(5, "[[0,1],[0,2],[0,3],[0,4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]",
                        "[[],[0],[0,1],[0,1,2],[0,1,2,3]]")
        );
    }

}