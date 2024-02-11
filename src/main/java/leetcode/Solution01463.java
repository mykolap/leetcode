package leetcode;

/**
 * https://leetcode.com/problems/cherry-pickup-ii/
 * 1463. Cherry Pickup II
 * Hard
 */
public class Solution01463 {

    // Time: O(m*n^2)
    // Space: O(m*n^2)
    public int cherryPickupDp3d(int[][] grid) {
        // Get the number of rows and columns in the grid
        int m = grid.length;
        int n = grid[0].length;

        // Initialize a 3D dynamic programming array
        int[][][] dp = new int[m][n][n];

        // Iterate over the rows from bottom to top
        for (int row = m - 1; row >= 0; row--) {
            // Iterate over all possible positions for the first robot
            for (int col1 = 0; col1 < n; col1++) {
                // Iterate over all possible positions for the second robot
                for (int col2 = 0; col2 < n; col2++) {
                    int result = 0;
                    // Add the cherries picked by the first robot
                    result += grid[row][col1];
                    // If the two robots are not at the same position, add the cherries picked by the second robot
                    if (col1 != col2) {
                        result += grid[row][col2];
                    }
                    // If we are not at the last row, add the maximum cherries that can be picked from the next row
                    if (row != m - 1) {
                        int max = 0;
                        // Iterate over all possible positions for the first robot in the next row
                        for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                            // Iterate over all possible positions for the second robot in the next row
                            for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                                // If the new positions are valid, update the maximum cherries that can be picked
                                if (newCol1 >= 0 && newCol1 < n && newCol2 >= 0 && newCol2 < n) {
                                    max = Math.max(max, dp[row + 1][newCol1][newCol2]);
                                }
                            }
                        }
                        // Add the maximum cherries that can be picked from the next row to the current result
                        result += max;
                    }
                    // Update the dynamic programming array
                    dp[row][col1][col2] = result;
                }
            }
        }

        // Return the maximum cherries that can be picked
        return dp[0][0][n - 1];
    }

    // Time: O(m*n^2)
    // Space: O(n^2)
    public int cherryPickupDp3dOptimized(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Initialize two 2D dynamic programming arrays
        int[][][] dp = new int[2][n][n];
        // Variables to keep track of current and next rows
        int curr = 0;
        int next = 1;

        for (int row = m - 1; row >= 0; row--) {
            for (int col1 = 0; col1 < n; col1++) {
                for (int col2 = 0; col2 < n; col2++) {
                    int result = grid[row][col1]; // Cherries picked by the first robot
                    if (col1 != col2) {
                        result += grid[row][col2]; // Add cherries picked by the second robot if they are not at the same position
                    }
                    if (row != m - 1) {
                        int max = 0;
                        for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                            for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                                // If the new positions are valid, update the maximum cherries that can be picked
                                if (newCol1 >= 0 && newCol1 < n && newCol2 >= 0 && newCol2 < n) {
                                    max = Math.max(max, dp[next][newCol1][newCol2]);
                                }
                            }
                        }
                        result += max; // Add the maximum cherries that can be picked from the next row to the current result
                    }
                    dp[curr][col1][col2] = result; // Update the dynamic programming array
                }
            }
            // Swap the current and next rows
            int temp = curr;
            curr = next;
            next = temp;
        }

        return dp[next][0][n - 1]; // Return the maximum cherries that can be picked
    }

}
