package leetcode;

/**
 * 840. Magic Squares In Grid
 * <a href="https://leetcode.com/problems/magic-squares-in-grid">Web link</a>
 * Medium
 */

public class Solution00840 {

    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;
        for (int i = 2; i < rows; i++) {
            for (int j = 2; j < cols; j++) {
                if (isMagicSquare(grid, i, j)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isMagicSquare(int[][] grid, int i, int j) {
        int[] count = new int[15];
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int num = grid[i - 2 + k][j - 2 + l];
                if (num < 1 || num > 9 || count[num] > 0) {
                    return false;
                }
                count[num]++;
            }
        }

        int diagonal0 = grid[i - 2][j - 2] + grid[i - 1][j - 1] + grid[i][j];
        int diagonal1 = grid[i][j - 2] + grid[i - 1][j - 1] + grid[i - 2][j];
        if (diagonal0 != diagonal1) {
            return false;
        }
        for (int k = -2; k <= 0; k++) {
            int row = i + k;
            int rowSum = grid[row][j - 2] + grid[row][j - 1] + grid[row][j];
            if (rowSum != diagonal0) {
                return false;
            }
            int col = j + k;
            int colSum = grid[i - 2][col] + grid[i - 1][col] + grid[i][col];
            if (colSum != diagonal0) {
                return false;
            }
        }
        return true;
    }

}