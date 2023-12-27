package leetcode.maxAreaOfIsland;

/**
 * https://leetcode.com/problems/max-area-of-island/
 * 695. Max Area of Island
 * <p>
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid
 * are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * [0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]
 * ]
 * Output: 6
 * <p>
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */
public class Solution0695 {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int len1 = grid.length;
        int len2 = grid[0].length;
        boolean[][] visited = new boolean[len1][len2];
        for (int row = 0; row < len1; row++) {
            for (int col = 0; col < len2; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    int currentArea = calcAreaDfs(grid, visited, row, col);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }

    private int calcAreaDfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[row].length ||
            visited[row][col] ||
            grid[row][col] != 1) {
            return 0;
        }
        visited[row][col] = true;

        return 1 +
               calcAreaDfs(grid, visited, row - 1, col) +
               calcAreaDfs(grid, visited, row + 1, col) +
               calcAreaDfs(grid, visited, row, col - 1) +
               calcAreaDfs(grid, visited, row, col + 1);
    }

}
