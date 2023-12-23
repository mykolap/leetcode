package leetcode.numberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * <p>
 * Medium
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded
 * by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four
 * edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input: 11110 11010 11000 00000
 * <p>
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: 11000 11000 00100 00011
 * <p>
 * Output: 3
 */
public class Solution0200 {

    // Time: O(n * m)
    // Space: O(n * m)
    public int numIslandsDfsBased(char[][] grid) {
        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++)
                if (grid[row][col] == '1' && !visited[row][col]) {
                    islands++;
                    dfs(grid, visited, row, col);
                }
        }

        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length
            || col < 0 || col >= grid[0].length
            || grid[row][col] == '0'
            || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        dfs(grid, visited, row - 1, col);
        dfs(grid, visited, row + 1, col);
        dfs(grid, visited, row, col - 1);
        dfs(grid, visited, row, col + 1);
    }

    // Time: O(n * m)
    // Space: O(n * m)
    public int numIslandsBfsBased(char[][] grid) {
        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++)
                if (grid[row][col] == '1' && !visited[row][col]) {
                    islands++;
                    bfs(grid, visited, row, col);
                }
        }

        return islands;
    }

    private void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            row = cell[0];
            col = cell[1];

            if (row < 0 || row >= grid.length
                || col < 0 || col >= grid[0].length
                || grid[row][col] == '0' || visited[row][col]) {
                continue;
            }

            visited[row][col] = true;
            queue.offer(new int[]{row - 1, col});
            queue.offer(new int[]{row + 1, col});
            queue.offer(new int[]{row, col - 1});
            queue.offer(new int[]{row, col + 1});
        }
    }

}
