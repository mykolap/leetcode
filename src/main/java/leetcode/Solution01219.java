package leetcode;

/**
 * 1219. Path with Maximum Gold
 * <a href="https://leetcode.com/problems/path-with-maximum-gold">Web link</a>
 * Medium
 */

public class Solution01219 {

    public int getMaximumGold(int[][] grid) {
        final int rowCount = grid.length;
        final int colCount = grid[0].length;
        boolean[][] visited = new boolean[rowCount][colCount];
        int result = Integer.MIN_VALUE;
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                result = Math.max(result, dfsAndBacktrack(grid, row, col, visited));
            }
        }
        return result;
    }

    private int dfsAndBacktrack(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {
            return 0;
        }
        if (grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        int result = grid[row][col];

        // try left
        result = Math.max(result, grid[row][col] + dfsAndBacktrack(grid, row, col - 1, visited));
        // try top
        result = Math.max(result, grid[row][col] + dfsAndBacktrack(grid, row - 1, col, visited));
        // try right
        result = Math.max(result, grid[row][col] + dfsAndBacktrack(grid, row, col + 1, visited));
        // try bottom
        result = Math.max(result, grid[row][col] + dfsAndBacktrack(grid, row + 1, col, visited));

        visited[row][col] = false;

        return result;
    }

}















































/*

        int rowCount = grid.length;
        int columnCount = grid[0].length;

        int maxGold = 0;
        boolean[][] visited = new boolean[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j, visited));
                }
            }
        }

        return maxGold;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        if (i < 0 || i >= rowCount || j < 0 || j >= columnCount || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
        int gold = grid[i][j];
        int maxGold = 0;

        maxGold = Math.max(maxGold, gold + dfs(grid, i - 1, j, visited));
        maxGold = Math.max(maxGold, gold + dfs(grid, i + 1, j, visited));
        maxGold = Math.max(maxGold, gold + dfs(grid, i, j - 1, visited));
        maxGold = Math.max(maxGold, gold + dfs(grid, i, j + 1, visited));

        visited[i][j] = false;
        return maxGold;
    }

 */