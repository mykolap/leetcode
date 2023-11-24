package leetcode.findMinimumInRotatedSortedArray;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 153. Find Minimum in Rotated Sorted Array
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 * Example 3:
 * <p>
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 */
public class Solution {

    // Time: O(logn)
    // Space: O(1)
    public int findMin(int[] nums) {
        // Create a variable to keep track of the left index.
        int left = 0;

        // Create a variable to keep track of the right index.
        int right = nums.length - 1;

        // Loop while the left index is less than the right index.
        while (left < right) {
            // Create a variable to keep track of the middle index.
            int mid = left + (right - left) / 2;

            // If the middle element is less than the right element.
            if (nums[mid] < nums[right]) {
                // Update the right index.
                right = mid;
            } else {
                // Update the left index.
                left = mid + 1;
            }
        }

        // Return the element at the left index.
        return nums[left];
    }

}
