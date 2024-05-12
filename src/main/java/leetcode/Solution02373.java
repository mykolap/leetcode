package leetcode;

/**
 * 2373. Largest Local Values in a Matrix
 * https://leetcode.com/problems/largest-local-values-in-a-matrix/
 * Easy
 */

public class Solution02373 {
    public int[][] largestLocal(int[][] grid) {
        int size = grid.length;
        final int newSize = size - 2;
        int[][] result = new int[newSize][newSize];

        for (int row = 1; row <= newSize; row++) {
            for (int col = 1; col <= newSize; col++) {
                result[row - 1][col - 1] = getMax3x3(grid, row, col);
            }
        }

        return result;
    }

    private int getMax3x3(int[][] grid, int row, int col) {
        int max = Integer.MIN_VALUE;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}