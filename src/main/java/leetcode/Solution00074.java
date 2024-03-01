package leetcode;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 74. Search a 2D Matrix
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * 1. Integers in each row are sorted from left to right.
 * 2. The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [ [1,3,5,7], [10,11,16,20], [23,30,34,50] ] target = 3 Output: true Example 2:
 * <p>
 * Input: matrix = [ [1,3,5,7], [10,11,16,20], [23,30,34,50] ] target = 13 Output: false Example 3:
 * <p>
 * Input: matrix = [] target = 0 Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length n == matrix[i].length 0 <= m, n <= 100 -104 <= matrix[i][j], target <= 104
 */
public class Solution00074 {

    // Time: O(logm + logn)
    // Space: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            int[] midRow = matrix[mid];
            if (midRow[0] <= target && target <= midRow[midRow.length - 1]) {
                return binarySearch(midRow, target);
            } else if (midRow[0] > target) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        // Create a variable to keep track of the left index.
        int left = 0;

        // Create a variable to keep track of the right index.
        int right = nums.length - 1;

        // Loop while the left index is less than or equal to the right index.
        while (left <= right) {
            // Create a variable to keep track of the middle index.
            int mid = left + (right - left) / 2;

            final int middleValue = nums[mid];

            // If the middle element is less than the target.
            if (middleValue < target) {
                // Update the left index.
                left = mid + 1;
            } else if (middleValue > target) {
                // Update the right index.
                right = mid - 1;
            } else {
                // Return the middle index.
                return true;
            }
        }

        // Return false.
        return false;
    }

}
