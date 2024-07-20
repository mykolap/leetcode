package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution01605Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void restoreMatrix(String rowSumStr, String colSumStr) {
        int[] rowSum = ArrayUtils.stringToIntArray(rowSumStr);
        int[] colSum = ArrayUtils.stringToIntArray(colSumStr);
        int[][] actual = new Solution01605().restoreMatrix(rowSum, colSum);

        verifyMatrix(actual, rowSum, colSum);
    }

    private void verifyMatrix(int[][] actual, int[] rowSum, int[] colSum) {
        int rows = actual.length;
        int cols = actual[0].length;
        int[] actualRowSum = new int[rows];
        int[] actualColSum = new int[cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                actualRowSum[row] += actual[row][col];
                actualColSum[col] += actual[row][col];
            }
        }
        System.out.println(Arrays.deepToString(actual));
        System.out.println(Arrays.toString(actualRowSum));
        System.out.println(Arrays.toString(actualColSum));
        assertArrayEquals(rowSum, actualRowSum);
        assertArrayEquals(colSum, actualColSum);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void restoreMatrixOptimized(String rowSumStr, String colSumStr) {
        int[] rowSum = ArrayUtils.stringToIntArray(rowSumStr);
        int[] colSum = ArrayUtils.stringToIntArray(colSumStr);
        int[][] actual = new Solution01605().restoreMatrixOptimized(rowSum, colSum);

        verifyMatrix(actual, rowSum, colSum);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[3,8]", "[4,7]"),
                Arguments.of("[5,7,10]", "[8,6,8]")
        );
    }

}