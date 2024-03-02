package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** https://leetcode.com/problems/pacific-atlantic-water-flow/
 * 417. Pacific Atlantic Water Flow
 * <p>
 * You are given an m x n integer matrix heights representing the height of each unit cell in a continent.
 * The Pacific ocean touches the continent's left and top edges, and the Atlantic ocean touches the continent's
 * right and bottom edges.
 * <p>
 * Water can only flow in four directions: up, down, left, and right. Water flows from a cell to an adjacent one
 * with an equal or lower height.
 * <p>
 * Return a list of grid coordinates where water can flow to both the Pacific and Atlantic oceans.
 * <p>
 * Example 1:
 * <p>
 * Input: heights = [[1,2,2,3,5],
 * [3,2,3,4,4],
 * [2,4,5,3,1],
 * [6,7,1,4,5],
 * [5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * <p>
 * Example 2:
 * <p>
 * Input: heights = [[2,1],[1,2]]
 * Output: [[0,0],[0,1],[1,0],[1,1]]
 * <p>
 * Constraints:
 * <p>
 * m == heights.length
 * n == heights[i].length
 * 1 <= m, n <= 200
 * 1 <= heights[i][j] <= 105
 */
public class Solution00417 {

    // Time: O(n * m)
    // Space: O(n * m)
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Create a list to store the result.
        List<List<Integer>> result = new ArrayList<>();

        // Check for invalid inputs.
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        // Get the number of rows and columns.
        int rows = heights.length;
        int cols = heights[0].length;

        // Create a boolean matrix to store the nodes that can reach the Pacific.
        boolean[][] canReachPacific = new boolean[rows][cols];

        // Create a boolean matrix to store the nodes that can reach the Atlantic.
        boolean[][] canReachAtlantic = new boolean[rows][cols];

        // Create a queue to store the nodes that can reach the Pacific.
        Queue<int[]> pacificQueue = new LinkedList<>();

        // Create a queue to store the nodes that can reach the Atlantic.
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // Iterate over the rows and add the nodes that can reach the Pacific to the queue.
        for (int row = 0; row < rows; row++) {
            pacificQueue.offer(new int[]{row, 0});
        }

        // Iterate over the columns and add the nodes that can reach the Pacific to the queue.
        for (int col = 0; col < cols; col++) {
            pacificQueue.offer(new int[]{0, col});
        }

        // Iterate over the rows and add the nodes that can reach the Atlantic to the queue.
        for (int row = 0; row < rows; row++) {
            atlanticQueue.offer(new int[]{row, cols - 1});
        }

        // Iterate over the columns and add the nodes
        // that can reach the Atlantic to the queue.
        for (int col = 0; col < cols; col++) {
            atlanticQueue.offer(new int[]{rows - 1, col});
        }

        // BFS to find the nodes that can reach the Pacific.
        bfs(heights, pacificQueue, canReachPacific);

        // BFS to find the nodes that can reach the Atlantic.
        bfs(heights, atlanticQueue, canReachAtlantic);

        // Iterate over the rows.
        for (int row = 0; row < rows; row++) {
            // Iterate over the columns.
            for (int col = 0; col < cols; col++) {
                // If the node can reach both the Pacific and the Atlantic,
                // add it to the result.
                if (canReachPacific[row][col] && canReachAtlantic[row][col]) {
                    result.add(List.of(row, col));
                }
            }
        }

        return result;
    }

    // BFS to find the nodes that can reach the ocean.
    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] canReachOcean) {
        // Get the number of rows and columns.
        int rows = heights.length;
        int cols = heights[0].length;

        // Create a boolean matrix to store the visited nodes.
        boolean[][] visited = new boolean[rows][cols];

        // Iterate while the queue is not empty.
        while (!queue.isEmpty()) {
            // Get the current node.
            int[] curr = queue.poll();

            // Get the row and column of the current node.
            int row = curr[0];
            int col = curr[1];

            // Mark the current node as visited.
            visited[row][col] = true;

            // Add the current node to the queue if it can reach the ocean.
            canReachOcean[row][col] = true;

            // Create an array to store the directions.
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            // Iterate over the directions.
            for (int[] direction : directions) {
                // Get the next row and column.
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                // Check if the next row and column are valid.
                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                    continue;
                }

                // Check if the next node is visited.
                if (visited[nextRow][nextCol]) {
                    continue;
                }

                // Check if the next node is higher than the current node.
                if (heights[nextRow][nextCol] < heights[row][col]) {
                    continue;
                }

                // Add the next node to the queue.
                queue.offer(new int[]{nextRow, nextCol});
            }
        }
    }

}
