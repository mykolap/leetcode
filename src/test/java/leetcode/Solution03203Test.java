package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03203Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumDiameterAfterMerge(String edges1Str, String edges2Str, int expected) {
        int[][] edges1 = ArrayUtils.stringToInt2DArray(edges1Str);
        int[][] edges2 = ArrayUtils.stringToInt2DArray(edges2Str);
        int result = new Solution03203().minimumDiameterAfterMerge(edges1, edges2);
        assertEquals(expected, result);
    }

    /*
    Example 1:

Input: edges1 = [[0,1],[0,2],[0,3]], edges2 = [[0,1]]

Output: 3

Explanation:

We can obtain a tree of diameter 3 by connecting node 0 from the first tree with any node from the second tree.

Example 2:


Input: edges1 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]], edges2 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]

Output: 5

Explanation:

We can obtain a tree of diameter 5 by connecting node 0 from the first tree with node 0 from the second tree.


     */
    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[0,1],[0,2],[0,3]]", "[[0,1]]", 3),
                Arguments.of("[[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]", "[[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]", 5)
        );
    }

}