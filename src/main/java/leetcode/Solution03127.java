package leetcode;

/**
 * 3127. Make a Square with the Same Color
 * <a href="https://leetcode.com/problems/make-a-square-with-the-same-color">Web link</a> |
 * Easy
 */

public class Solution03127 {

    public boolean canMakeSquare(char[][] grid) {
        final int n = grid.length;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int blackCount = amountInSquare(grid, i, j, 'B');
                int whiteCount = amountInSquare(grid, i, j, 'W');
                if (blackCount >= 3 || whiteCount >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private int amountInSquare(char[][] grid, int i, int j, char color) {
        int amount = 0;
        if (grid[i - 1][j - 1] == color) {
            amount++;
        }
        if (grid[i - 1][j] == color) {
            amount++;
        }
        if (grid[i][j - 1] == color) {
            amount++;
        }
        if (grid[i][j] == color) {
            amount++;
        }
        return amount;
    }

}
