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
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        System.out.println(new Solution().spiralOrder(matrix));

        int[][] matrix2 = {{7},
                {9},
                {6}};

        System.out.println(new Solution().spiralOrder(matrix2));

        int[][] matrix3 = {{2, 5, 8},
                {4, 0, -1}};

        System.out.println(new Solution().spiralOrder(matrix3));
    }

    // Time: O(n)
    // Space: O(n)
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        final int matrixSize = rows * columns;
        List<Integer> result = new ArrayList<>(matrixSize);

        // Initialize the boundaries of the matrix.
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = columns - 1;

        // Iterate through the matrix.
        while (true) {
            // first from left to right.
            if (top <= bottom) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
            }
            // Increment the top boundary.
            top++;

            // second from top to bottom.
            if (left <= right) {
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
            }
            // Decrement the right boundary.
            right--;

            // third from right to left.
            if (top <= bottom) { // for last iteration - only left to right should be done (not right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
            }
            // Decrement the bottom boundary.
            bottom--;

            // last bottom to top.
            if (left <= right) { // for last iteration - only top to bottom should be done (not bottom to top)
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            // Increment the left boundary.
            left++;

            if (result.size() == matrixSize) {
                break;
            }
        }

        return result;
    }

}
