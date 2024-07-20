package leetcode;

import java.util.Arrays;

/**
 * 1605. Find Valid Matrix Given Row and Column Sums
 * <a href="https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums">Web link</a> |
 * Medium
 */

public class Solution01605 {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] result = new int[rowSum.length][colSum.length];
        for (int rowIdx = 0; rowIdx < rowSum.length; rowIdx++) {
            result[rowIdx][0] = rowSum[rowIdx];
        }
        for (int colIdx = 0; colIdx < colSum.length; colIdx++) {
            int currentColSum = 0;
            for (int rowIdx = 0; rowIdx < rowSum.length; rowIdx++) {
                currentColSum += result[rowIdx][colIdx];
            }

            int rowIdx = 0;
            while (currentColSum > colSum[colIdx]) {
                int diff = currentColSum - colSum[colIdx];
                int maxShift = Math.min(diff, result[rowIdx][colIdx]);
                result[rowIdx][colIdx] -= maxShift;
                result[rowIdx][colIdx + 1] += maxShift;
                currentColSum -= maxShift;
                rowIdx++;
            }
        }

        return result;
    }

    public int[][] restoreMatrixOptimized(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] result = new int[rows][cols];

        int[] rowSumCopy = Arrays.copyOf(rowSum, rows);
        int[] colSumCopy = Arrays.copyOf(colSum, cols);

        for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
            for (int colIdx = 0; colIdx < cols; colIdx++) {
                int minVal = Math.min(rowSumCopy[rowIdx], colSumCopy[colIdx]);
                result[rowIdx][colIdx] = minVal;
                rowSumCopy[rowIdx] -= minVal;
                colSumCopy[colIdx] -= minVal;
            }
        }
        return result;
    }

}