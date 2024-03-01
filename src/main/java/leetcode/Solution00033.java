package leetcode;

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Medium
 * <p>
 * You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.
 * <p>
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might
 * become [4,5,6,7,0,1,2]).
 * <p>
 * If target is found in the array return its index, otherwise, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4 Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1 Example 3:
 * <p>
 * Input: nums = [1], target = 0 Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5000 -104 <= nums[i] <= 104 All values of nums are unique. nums is guranteed to
 * be rotated at some pivot. -104 <= target <= 104
 */
public class Solution00033 {

    // Time: O(logn)
    // Space: O(1)
    public int search(int[] nums, int target) {
        // Create a variable to keep track of the left index.
        int left = 0;

        // Create a variable to keep track of the right index.
        int right = nums.length - 1;

        // Loop while the left index is less than or equal to the right index.
        while (left <= right) {
            // Create a variable to keep track of the middle index.
            int mid = left + (right - left) / 2;

            final int middleValue = nums[mid];

            if (middleValue == target) {
                // Return the middle index.
                return mid;
            }

            if (nums[left] <= middleValue) { // values are sorted in the left half
                if (target >= middleValue || // target is greater than the middle value
                    target < nums[left]) { // target is less than the left value
                    // Update the left index, values are in the right half.
                    left = mid + 1;
                } else {
                    // Update the right index, values are in the left half.
                    right = mid - 1;
                }
            } else { // values are sorted in the right half
                if (target <= middleValue || // target is less than the middle value
                    target > nums[right]) { // target is greater than the right value
                    // Update the right index, values are in the left half.
                    right = mid - 1;
                } else {
                    // Update the left index, values are in the right half.
                    left = mid + 1;
                }
            }
        }

        // Return -1.
        return -1;
    }

}
