package leetcode;

/**
 * 463. Island Perimeter
 * <a href="https://leetcode.com/problems/island-perimeter">Web link</a>
 * Easy
 */

public class Solution00463 {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                perimeter += perimeter(grid, row, col);
            }
        }
        return perimeter;
    }

    private int perimeter(int[][] grid, int row, int col) {
        if (grid[row][col] == 0) {
            return 0;
        }
        int perimeter = 0;
        // top border
        if (row == 0 || grid[row - 1][col] == 0) {
            perimeter++;
        }
        // bottom border
        if (row == grid.length - 1 || grid[row + 1][col] == 0) {
            perimeter++;
        }
        // left border
        if (col == 0 || grid[row][col - 1] == 0) {
            perimeter++;
        }
        // right border
        if (col == grid[0].length - 1 || grid[row][col + 1] == 0) {
            perimeter++;
        }
        return perimeter;
    }

}