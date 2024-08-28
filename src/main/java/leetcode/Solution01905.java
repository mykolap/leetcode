package leetcode;

/**
 * 1905. Count Sub Islands
 * <a href="https://leetcode.com/problems/count-sub-islands">Web link</a> |
 * Medium
 */

public class Solution01905 {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;    // Number of rows in the grid
        int n = grid1[0].length; // Number of columns in the grid

        int subIslandCount = 0;  // To store the count of sub-islands

        // Iterate through each cell in grid2
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell is land in grid2, it could be part of a sub-island
                if (grid2[i][j] == 1) {
                    boolean[] isSubIsland = {true};  // Start assuming this is a sub-island
                    dfs(grid1, grid2, i, j, isSubIsland);  // Perform DFS to check the whole island

                    // If the flag remains true after DFS, it means this island is a sub-island
                    if (isSubIsland[0]) {
                        subIslandCount++;  // Increment the count of sub-islands
                    }
                }
            }
        }

        return subIslandCount;  // Return the total count of sub-islands
    }

    public void dfs(int[][] grid1, int[][] grid2, int i, int j, boolean[] isSubIsland) {
        int m = grid1.length;    // Number of rows in the grid
        int n = grid1[0].length; // Number of columns in the grid

        // If the current position is out of bounds or already visited (grid2[i][j] == 0), return
        if (i < 0 || i == m || j < 0 || j == n || grid2[i][j] == 0) return;

        // If the current cell in grid2 is land but not in grid1, mark this island as not a sub-island
        if (grid1[i][j] != grid2[i][j]) {
            isSubIsland[0] = false;
        }

        // Mark the current cell as visited by setting grid2[i][j] to 0
        grid2[i][j] = 0;

        // Continue the DFS in all four directions
        dfs(grid1, grid2, i + 1, j, isSubIsland);  // Down
        dfs(grid1, grid2, i - 1, j, isSubIsland);  // Up
        dfs(grid1, grid2, i, j + 1, isSubIsland);  // Right
        dfs(grid1, grid2, i, j - 1, isSubIsland);  // Left
    }
}