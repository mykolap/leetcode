package leetcode.rotateImage;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/
 * 48. Rotate Image
 * <p>
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * Output: [[7,4,1],
 * [8,5,2],
 * [9,6,3]]
 * <p>
 * Example 2:
 * <p>
 * Input: matrix = [[5,1,9,11],
 * [2,4,8,10],
 * [13,3,6,7],
 * [15,14,12,16]]
 * Output: [[15,13,2,5],
 * [14,3,4,1],
 * [12,6,8,9],
 * [16,7,10,11]]
 * <p>
 * Example 3:
 * <p>
 * Input: matrix = [[1]]
 * Output: [[1]]
 * <p>
 * Example 4:
 * <p>
 * Input: matrix = [[1,2],
 * [3,4]]
 * Output: [[3,1],
 * [4,2]]
 * <p>
 * Constraints:
 * <p>
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 * <p>
 * Hide Hint #1
 * <p>
 * The easiest solution would use additional memory and two passes.
 * <p>
 * Hide Hint #2
 * <p>
 * Can we do it in one pass?
 * <p>
 * Hide Hint #3
 * <p>
 * Related problem: Rotate Array
 * <p>
 * Hide Hint #4
 * <p>
 * First reverse up to down, then swap the symmetry
 */
public class Solution {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println("Before rotate:" + Arrays.deepToString(matrix));

        new Solution().rotate(matrix);

        System.out.println("After rotate:" + Arrays.deepToString(matrix));

        int[][] matrix2 = {{5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};

        System.out.println("Before rotate:" + Arrays.deepToString(matrix2));

        new Solution().rotate(matrix2);

        System.out.println("After rotate:" + Arrays.deepToString(matrix2));
    }

    // Time: O(n)
    // Space: O(1)
    public void rotate(int[][] matrix) {
        // Get the size of the matrix.
        int n = matrix.length;

        // Initialize the start and end indices.
        int start = 0;
        int end = n - 1;

        // Initialize a temporary variable to store the top-left element of the matrix.
        int tempTopLeft;

        // Rotate the matrix until the start and end indices meet.
        while (start < end) {
            // Calculate the range of elements to rotate on this iteration.
            int range = end - start;

            // Iterate over the range of elements to rotate.
            for (int i = 0; i < range; i++) {
                // Save the top-left element of the matrix to a temporary variable.
                tempTopLeft = matrix[start][start + i];

                // Move the bottom-left element to the top-left corner.
                matrix[start][start + i] = matrix[end - i][start];

                // Move the bottom-right element to the bottom-left corner.
                matrix[end - i][start] = matrix[end][end - i];

                // Move the top-right element to the bottom-right corner.
                matrix[end][end - i] = matrix[start + i][end];

                // Move the saved top-left element to the top-right corner.
                matrix[start + i][end] = tempTopLeft;
            }

            // Increment the start and decrement the end indices.
            start++;
            end--;
        }
    }

}
