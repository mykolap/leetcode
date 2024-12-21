package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02872Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxKDivisibleComponents(int n, String edgesStr, String valuesStr, int k, int expected) {
        int[][] edges = ArrayUtils.stringToInt2DArray(edgesStr);
        int[] values = ArrayUtils.stringToIntArray(valuesStr);
        assertEquals(expected, new Solution02872().maxKDivisibleComponents(n, edges, values, k));
    }

    /*
    Example 1:


Input: n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6
Output: 2
Explanation: We remove the edge connecting node 1 with 2. The resulting split is valid because:
- The value of the component containing nodes 1 and 3 is values[1] + values[3] = 12.
- The value of the component containing nodes 0, 2, and 4 is values[0] + values[2] + values[4] = 6.
It can be shown that no other valid split has more than 2 connected components.
Example 2:


Input: n = 7, edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [3,0,6,1,5,2,1], k = 3
Output: 3
Explanation: We remove the edge connecting node 0 with 2, and the edge connecting node 0 with 1. The resulting split is valid because:
- The value of the component containing node 0 is values[0] = 3.
- The value of the component containing nodes 2, 5, and 6 is values[2] + values[5] + values[6] = 9.
- The value of the component containing nodes 1, 3, and 4 is values[1] + values[3] + values[4] = 6.
It can be shown that no other valid split has more than 3 connected components.
     */

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(5, "[[0,2],[1,2],[1,3],[2,4]]", "[1,8,1,4,4]", 6, 2),
                Arguments.of(7, "[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]", "[3,0,6,1,5,2,1]", 3, 3)
        );
    }

}