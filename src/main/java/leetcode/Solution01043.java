package leetcode;

/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum
 * 1043. Partition Array for Maximum Sum
 * Medium
 * <p>
 * Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.
 * <p>
 * Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,15,7,9,2,5,10], k = 3
 * Output: 84
 * Explanation: arr becomes [15,15,15,9,10,10,10]
 * Example 2:
 * <p>
 * Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * Output: 83
 * Example 3:
 * <p>
 * Input: arr = [1], k = 1
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 109
 * 1 <= k <= arr.length
 */
public class Solution01043 {

    // Time complexity: O(n * k)
    // Space complexity: O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Get the length of the input array
        int n = arr.length;

        // Initialize a dynamic programming array with size n+1
        int[] dp = new int[n + 1];

        // Iterate over the array
        for (int i = 1; i <= n; i++) {
            // Initialize the maximum value for the current subarray
            int max = 0;

            // Iterate over the subarray of length at most k
            for (int j = 1; j <= k && i - j >= 0; j++) {
                // Update the maximum value if the current value is greater
                max = Math.max(max, arr[i - j]);

                // Update the dp value for the current position with the maximum sum of partition
                dp[i] = Math.max(dp[i], dp[i - j] + max * j);
            }
        }

        // Return the maximum sum after partitioning
        return dp[n];
    }

}