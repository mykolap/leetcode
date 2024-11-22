package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01072Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxEqualRowsAfterFlips(String matrixStr, int expected) {
        int[][] matrix = ArrayUtils.stringTo2DIntArray(matrixStr);
        int actual = new Solution01072().maxEqualRowsAfterFlips(matrix);
        assertEquals(expected, actual);
    }

    /*
    Example 1:

Input: matrix = [[0,1],[1,1]]
Output: 1
Explanation: After flipping no values, 1 row has all values equal.
Example 2:

Input: matrix = [[0,1],[1,0]]
Output: 2
Explanation: After flipping values in the first column, both rows have equal values.
Example 3:

Input: matrix = [[0,0,0],[0,0,1],[1,1,0]]
Output: 2
Explanation: After flipping values in the first two columns, the last two rows have equal values.
     */
    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[0,1],[1,1]]", 1),
                Arguments.of("[[0,1],[1,0]]", 2),
                Arguments.of("[[0,0,0],[0,0,1],[1,1,0]]", 2)
        );
    }

}