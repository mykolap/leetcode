package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/">
 * 1074. Number of Submatrices That Sum to Target
 * Hard
 * <p>
 * Given a matrix and a target, return the number of non-empty submatrices that sum to target.
 * <p>
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
 * <p>
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * Output: 4
 * Explanation: The four 1x1 submatrices that only contain 0.
 * Example 2:
 * <p>
 * Input: matrix = [[1,-1],[-1,1]], target = 0
 * Output: 5
 * Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
 * Example 3:
 * <p>
 * Input: matrix = [[904]], target = 0
 * Output: 0
 * <p>
 * Constraints:
 * <p>
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 */
public class Solution01074 {

    // Time O(m^2 * n^2)
    // Space O(m * n)
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // Get the number of rows and columns in the matrix
        int m = matrix.length;
        int n = matrix[0].length;

        // Initialize a prefix sum matrix with an extra row and column for easier calculation
        int[][] prefixSum = new int[m + 1][n + 1];

        // Calculate the prefix sum for each cell in the matrix
        for (int row = 1; row <= m; row++) {
            int rowSum = 0;
            for (int column = 1; column <= n; column++) {
                // Add the current cell value to the row sum
                rowSum += matrix[row - 1][column - 1];

                // The prefix sum at the current cell is the sum of the previous row's prefix sum and the current row sum
                prefixSum[row][column] = prefixSum[row - 1][column] + rowSum;
            }
        }

        // Initialize a counter for the number of submatrices that sum to the target
        int count = 0;

        // Iterate over all possible submatrices in the matrix
        for (int rowEnd = 1; rowEnd <= m; rowEnd++) {
            for (int rowStart = 1; rowStart <= rowEnd; rowStart++) {
                for (int columnEnd = 1; columnEnd <= n; columnEnd++) {
                    for (int columnStart = 1; columnStart <= columnEnd; columnStart++) {
                        // Calculate the sum of the current submatrix using the prefix sum matrix
                        int sum = prefixSum[rowEnd][columnEnd] -
                                  prefixSum[rowEnd - rowStart][columnEnd] -
                                  prefixSum[rowEnd][columnEnd - columnStart] +
                                  prefixSum[rowEnd - rowStart][columnEnd - columnStart];

                        // If the sum of the current submatrix equals the target, increment the counter
                        if (sum == target) {
                            count++;
                        }
                    }
                }
            }
        }

        // Return the number of submatrices that sum to the target
        return count;
    }

    // Time O(m^2 * n)
    // Space O(m * n)
    public int numSubmatrixSumTargetOptimized(int[][] matrix, int target) {
        // Get the number of rows and columns in the matrix
        int m = matrix.length;
        int n = matrix[0].length;

        // Initialize a prefix sum matrix with an extra row and column for easier calculation
        int[][] prefixSum = new int[m + 1][n + 1];

        // Calculate the prefix sum for each cell in the matrix
        for (int row = 1; row <= m; row++) {
            int rowSum = 0;
            for (int column = 1; column <= n; column++) {
                // Add the current cell value to the row sum
                rowSum += matrix[row - 1][column - 1];

                // The prefix sum at the current cell is the sum of the previous row's prefix sum and the current row sum
                prefixSum[row][column] = prefixSum[row - 1][column] + rowSum;
            }
        }

        // Initialize a counter for the number of submatrices that sum to the target
        int count = 0;

        // Iterate over all possible submatrices in the matrix
        for (int rowEnd = 1; rowEnd <= m; rowEnd++) {
            for (int rowStart = 1; rowStart <= rowEnd; rowStart++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int column = 1; column <= n; column++) {
                    int sum = prefixSum[rowEnd][column] - prefixSum[rowStart - 1][column];
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        // Return the number of submatrices that sum to the target
        return count;
    }

}