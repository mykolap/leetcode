package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02940Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void leftmostBuildingQueries(String heightsStr, String queriesStr, String expectedStr) {
        int[] heights = ArrayUtils.stringToIntArray(heightsStr);
        int[][] queries = ArrayUtils.stringToInt2DArray(queriesStr);
        final int[] actual = new Solution02940().leftmostBuildingQueries(heights, queries);
        assertThat(ArrayUtils.intArrayToString(actual))
                .isEqualTo(expectedStr);
    }

    /*
    Example 1:

Input: heights = [6,4,8,5,2,7], queries = [[0,1],[0,3],[2,4],[3,4],[2,2]]
Output: [2,5,-1,5,2]
Explanation: In the first query, Alice and Bob can move to building 2 since heights[0] < heights[2] and heights[1] < heights[2].
In the second query, Alice and Bob can move to building 5 since heights[0] < heights[5] and heights[3] < heights[5].
In the third query, Alice cannot meet Bob since Alice cannot move to any other building.
In the fourth query, Alice and Bob can move to building 5 since heights[3] < heights[5] and heights[4] < heights[5].
In the fifth query, Alice and Bob are already in the same building.
For ans[i] != -1, It can be shown that ans[i] is the leftmost building where Alice and Bob can meet.
For ans[i] == -1, It can be shown that there is no building where Alice and Bob can meet.
Example 2:

Input: heights = [5,3,8,2,6,1,4,6], queries = [[0,7],[3,5],[5,2],[3,0],[1,6]]
Output: [7,6,-1,4,6]
Explanation: In the first query, Alice can directly move to Bob's building since heights[0] < heights[7].
In the second query, Alice and Bob can move to building 6 since heights[3] < heights[6] and heights[5] < heights[6].
In the third query, Alice cannot meet Bob since Bob cannot move to any other building.
In the fourth query, Alice and Bob can move to building 4 since heights[3] < heights[4] and heights[0] < heights[4].
In the fifth query, Alice can directly move to Bob's building since heights[1] < heights[6].
For ans[i] != -1, It can be shown that ans[i] is the leftmost building where Alice and Bob can meet.
For ans[i] == -1, It can be shown that there is no building where Alice and Bob can meet.


     */

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[6,4,8,5,2,7]", "[[0,1],[0,3],[2,4],[3,4],[2,2]]", "[2,5,-1,5,2]"),
                Arguments.of("[5,3,8,2,6,1,4,6]", "[[0,7],[3,5],[5,2],[3,0],[1,6]]", "[7,6,-1,4,6]")
        );
    }

}