package leetcode;

/**
 * 576. Out of Boundary Paths
 * https://leetcode.com/problems/out-of-boundary-paths/description/?envType=daily-question&envId=2024-01-26
 * Medium
 * <p>
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
 * <p>
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * Output: 6
 * Example 2:
 * <p>
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * Output: 12
 * <p>
 * Constraints:
 * <p>
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 */
public class Solution00576 {

    // Time O(numRows*numColumns*maxMove)
    // Space O(numRows*numColumns*maxMove)
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // Initialize a 3D array to store the number of paths for each cell at each move
        int numRows = m;
        int numColumns = n;
        int[][][] dp = new int[numRows][numColumns][maxMove + 1];

        // Iterate over the number of moves
        for (int currentMove = 1; currentMove <= maxMove; currentMove++) {

            // Iterate over the rows of the grid
            for (int currentRow = 0; currentRow < numRows; currentRow++) {

                // Iterate over the columns of the grid
                for (int currentColumn = 0; currentColumn < numColumns; currentColumn++) {

                    // If the ball is at the top edge of the grid, add 1 to the number of paths
                    long topEdgePaths = (currentRow == 0 ? 1 : dp[currentRow - 1][currentColumn][currentMove - 1]);

                    // If the ball is at the bottom edge of the grid, add 1 to the number of paths
                    long bottomEdgePaths = (currentRow == numRows - 1 ? 1 : dp[currentRow + 1][currentColumn][currentMove - 1]);

                    // If the ball is at the left edge of the grid, add 1 to the number of paths
                    long leftEdgePaths = (currentColumn == 0 ? 1 : dp[currentRow][currentColumn - 1][currentMove - 1]);

                    // If the ball is at the right edge of the grid, add 1 to the number of paths
                    long rightEdgePaths = (currentColumn == numColumns - 1 ? 1 : dp[currentRow][currentColumn + 1][currentMove - 1]);

                    // Calculate the total number of paths for the current cell at the current move
                    final long allEdgePaths = (topEdgePaths + bottomEdgePaths + leftEdgePaths + rightEdgePaths) % 1000000007;
                    dp[currentRow][currentColumn][currentMove] = (int) allEdgePaths;
                }
            }
        }

        // Return the number of paths for the starting cell after the maximum number of moves
        return dp[startRow][startColumn][maxMove];
    }

}
