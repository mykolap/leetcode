package leetcode;

/** https://leetcode.com/problems/maximum-subarray/
 * 53. Maximum Subarray
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
 * sum and return its sum.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has the largest sum = 6. Example 2:
 * <p>
 * Input: nums = [1] Output: 1 Example 3:
 * <p>
 * Input: nums = [5,4,-1,7,8] Output: 23
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104 -105 <= nums[i] <= 105
 */
public class Solution00053 {

    // Time: O(n)
    // Space: O(1)
    public int maxSubArray(int[] nums) {
        // Initialize the max sum to the first element.
        int maxSum = nums[0];

        // Initialize the current sum to the first element.
        int currentSum = nums[0];

        // Iterate over the array starting from the second element.
        for (int i = 1; i < nums.length; i++) {
            // Update the current sum
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update the max sum.
            maxSum = Math.max(maxSum, currentSum);
        }

        // Return the max sum.
        return maxSum;
    }

}
