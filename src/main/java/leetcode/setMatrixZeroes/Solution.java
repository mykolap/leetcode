package leetcode.setMatrixZeroes;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * 73. Set Matrix Zeroes
 * <p>
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's,
 * and return the matrix.
 * <p>
 * You must do it in place.
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * Output: [[1,0,1],
 * [0,0,0],
 * [1,0,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: matrix = [[0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]]
 * Output: [[0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]]
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 * <p>
 * Follow up:
 * <p>
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class Solution {

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};

        new Solution().setZeroes(matrix);

        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    // Time: O(m * n)
    // Space: O(1)
    public void setZeroes(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        // Check if first row has zero
        for (int cell : matrix[0]) {
            if (cell == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Check if first column has zero
        for (int[] row : matrix) {
            if (row[0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        // Check for zeros
        for (int row = 1; row < matrix.length; row++) {
            for (int column = 1; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {
                    // Set first cell of the row and column to zero
                    matrix[row][0] = 0;
                    matrix[0][column] = 0;
                }
            }
        }

        // Nullify rows based on values in first column
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                nullifyRow(matrix, row);
            }
        }

        // Nullify columns based on values in first row
        for (int column = 1; column < matrix[0].length; column++) {
            if (matrix[0][column] == 0) {
                nullifyColumn(matrix, column);
            }
        }

        // Nullify first row
        if (firstRowHasZero) {
            nullifyRow(matrix, 0);
        }

        // Nullify first column
        if (firstColumnHasZero) {
            nullifyColumn(matrix, 0);
        }
    }

    private void nullifyColumn(int[][] matrix, int column) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][column] = 0;
        }
    }

    private void nullifyRow(int[][] matrix, int row) {
        Arrays.fill(matrix[row], 0);
    }

}
