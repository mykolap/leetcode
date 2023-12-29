package leetcode.jumpGameIi;

import java.util.Arrays;

/**
 * 45. Jump Game II
 * <p>
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array. Each
 * element in the array represents your maximum jump length at that position. Your goal is to reach the last index in
 * the minimum number of jumps. You can assume that you can always reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
 * step from index 0 to 1, then 3 steps to the last index. Example 2:
 * <p>
 * Input: nums = [2,3,0,1,4] Output: 2
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104 0 <= nums[i] <= 1000
 */
public class Solution0045 {

    // Time: O(n^2)
    // Space: O(n)
    public int jumpRecursive(int[] nums) {
        final int jumps = jumpRecursive(nums, 0);
        if (jumps == Integer.MAX_VALUE) {
            return -1;
        }
        return jumps;
    }

    private int jumpRecursive(int[] nums, int i) {
        // If we're at the last index, no more jumps are needed.
        if (i >= nums.length - 1) {
            return 0;
        }

        // If we're not at the last index, iterate from i + 1 to i + nums[i] and recursively call jump for each index.
        int minJumps = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
            int jumps = jumpRecursive(nums, j);
            if (jumps != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, jumps + 1);
            }
        }

        return minJumps;
    }

    // Time: O(n)
    // Space: O(1)
    public int jumpGreedy(int[] nums) {
        // If the array is null or with length <= 1, return 0.
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        // Initialize the number of jumps to 0.
        int jumps = 0;

        // Initialize the current jump end to 0.
        int currentJumpEnd = 0;

        // Initialize the farthest jump to 0.
        int farthestJump = 0;

        // Iterate over the array of numbers.
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest jump to the maximum of the current farthest jump and the index plus the number at the
            // index.
            farthestJump = Math.max(farthestJump, i + nums[i]);

            // If the current index is equal to the current jump end, increment the number of jumps and update the
            // current jump end to the farthest jump.
            if (i == currentJumpEnd) {
                jumps++;
                if (farthestJump > currentJumpEnd) {
                    currentJumpEnd = farthestJump;
                } else {
                    return -1; // Cannot reach the end.
                }
            }
        }

        // Return the number of jumps.
        return jumps;
    }

    // Time: O(n^2)
    // Space: O(n)
    public int jumpDp(int[] nums) {
        // If the array is null or with length <= 1, return 0.
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int n = nums.length;
        int[] jumps = new int[n];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    if (jumps[j] == Integer.MAX_VALUE) {
                        return -1;
                    }
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                }
            }
        }

        return jumps[n - 1];
    }

}
