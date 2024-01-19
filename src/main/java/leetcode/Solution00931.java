package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 * 931. Minimum Falling Path Sum
 * Medium
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * <p>
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 * <p>
 * Example 1:
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * <p>
 * Example 2:
 * Input: matrix = [[-19,57],[-40,-5]]
 * Output: -59
 * <p>
 * Example 3:
 * Input: matrix = [[-48]]
 * Output: -48
 * <p>
 * Constraints:
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 */
public class Solution00931 {

    // Time: O(n^2)
    // Space: O(n^2)
    public static int minFallingPathSum(int[][] matrix) {
        int size = matrix.length;
        int lastIndex = size - 1;
        int[][] dp = new int[size][size];

        // copy first row
        dp[0] = Arrays.copyOf(matrix[0], size);

        // fill dp, row by row starting from second row
        for (int row = 1; row < size; row++) {
            for (int column = 0; column < size; column++) {
                final int min;
                final int[] previousDpRow = dp[row - 1];
                if (column == 0) { // first column
                    min = Math.min(previousDpRow[0], previousDpRow[1]);
                } else if (column == lastIndex) { // last column
                    min = Math.min(previousDpRow[lastIndex - 1], previousDpRow[lastIndex]);
                } else {
                    min = Math.min(Math.min(previousDpRow[column - 1], previousDpRow[column]), previousDpRow[column + 1]);
                }
                dp[row][column] = min + matrix[row][column];
            }
        }

        // find min in last row
        int min = dp[lastIndex][0];
        for (int i = 1; i < size; ++i) {
            min = Math.min(min, dp[lastIndex][i]);
        }

        return min;
    }

}
