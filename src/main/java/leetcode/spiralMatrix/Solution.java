package leetcode.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * 54. Spiral Matrix
 * <p>
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * Example 2:
 * <p>
 * Input: matrix = [[1,2,3,4],
 * [5,6,7,8],
 * [9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class Solution {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        final List<Integer> result = new Solution().spiralOrder(matrix);
        System.out.println(result);
    }

    // Time: O(n)
    // Space: O(n)
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        List<Integer> result = new ArrayList<>(rows * columns);

        // Initialize the boundaries of the matrix.
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = columns - 1;

        // Initialize the direction.
        int direction = 0;

        // Iterate through the matrix.
        while (top <= bottom && left <= right) {
            // If the direction is 0, iterate from left to right.
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                // Increment the top boundary.
                top++;
            }
            // If the direction is 1, iterate from top to bottom.
            else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                // Decrement the right boundary.
                right--;
            }
            // If the direction is 2, iterate from right to left.
            else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                // Decrement the bottom boundary.
                bottom--;
            }
            // If the direction is 3, iterate from bottom to top.
            else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                // Increment the left boundary.
                left++;
            }

            // Update the direction.
            direction = (direction + 1) % 4;
        }

        return result;
    }

}
