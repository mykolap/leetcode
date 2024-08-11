package leetcode;

/**
 * 1568. Minimum Number of Days to Disconnect Island
 * <a href="https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island">Web link</a> |
 * Hard
 */

public class Solution01568 {

    public int minDays(int[][] grid) {
        int amountOfIslandsOriginal = getAmountOfIslands(grid);
        if (amountOfIslandsOriginal != 1) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    grid[row][col] = 0;
                    int amountOfIslands = getAmountOfIslands(grid);
                    if (amountOfIslands != 1) {
                        return 1;
                    }
                    grid[row][col] = 1;
                }
            }
        }

        return 2;
    }

    private int getAmountOfIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int count;
        count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    if (!visited[row][col]) {
                        dfs(row, col, visited, grid);
                        count += 1;
                        if (count > 1) {
                            return count;
                        }
                    }
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, boolean[][] visited, int[][] grid) {
        if (row < 0 ||
            col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            grid[row][col] == 0 ||
            visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        dfs(row - 1, col, visited, grid);
        dfs(row + 1, col, visited, grid);
        dfs(row, col - 1, visited, grid);
        dfs(row, col + 1, visited, grid);
    }

}