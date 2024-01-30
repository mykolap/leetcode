package leetcode;

/**
 * https://leetcode.com/problems/binary-search/
 * 704. Binary Search
 * <p>
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums.
 * If target exists, then return its index, otherwise return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 9 Output: 4 Explanation: 9 exists in nums and its index is 4 Example 2:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2 Output: -1 Explanation: 2 does not exist in nums so return -1
 * <p>
 * Note:
 * <p>
 * You may assume that all elements in nums are unique. n will be in the range [1, 10000]. The value of each element in nums will be in the range [-9999, 9999].
 */
public class Solution00704 {

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

            // If the middle element is less than the target.
            if (middleValue < target) {
                // Update the left index.
                left = mid + 1;
            } else if (middleValue > target) {
                // Update the right index.
                right = mid - 1;
            } else {
                // Return the middle index.
                return mid;
            }
        }

        // Return -1.
        return -1;
    }

}
