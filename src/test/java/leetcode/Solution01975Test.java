package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01975Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxMatrixSum(String matrixStr, long expected) {
        int[][] matrix = ArrayUtils.stringToInt2DArray(matrixStr);
        long result = new Solution01975().maxMatrixSum(matrix);
        assertEquals(expected, result);
    }

    /*
    Example 1:


Input: matrix = [[1,-1],[-1,1]]
Output: 4
Explanation: We can follow the following steps to reach sum equals 4:
- Multiply the 2 elements in the first row by -1.
- Multiply the 2 elements in the first column by -1.
Example 2:


Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
Output: 16
Explanation: We can follow the following step to reach sum equals 16:
- Multiply the 2 last elements in the second row by -1.
     */

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,-1],[-1,1]]", 4),
                Arguments.of("[[1,2,3],[-1,-2,-3],[1,2,3]]", 16)
        );
    }

}