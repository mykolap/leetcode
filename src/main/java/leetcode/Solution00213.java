package leetcode;

/**
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/description/
 * Medium
 */
public class Solution00213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int robFromFirst = rob(nums, 0, nums.length - 1);
        int robFromSecond = rob(nums, 1, nums.length - 1);
        return Math.max(robFromFirst, robFromSecond);
    }

    private int rob(int[] nums, int indexStart, int size) {
        int[] dp = new int[nums.length + 1];
        dp[indexStart] = 0;
        dp[indexStart + 1] = nums[indexStart];
        final int indexEnd = indexStart + size;
        for (int i = indexStart + 2; i <= indexEnd; i++) {
            int skipCurrent = dp[i - 1];
            int includeCurrent = dp[i - 2] + nums[i - 1];
            dp[i] = Math.max(skipCurrent, includeCurrent);
        }
        return dp[indexEnd];
    }

    public int robOptimized(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int robFromFirst = robOptimized(nums, 0, nums.length - 1);
        int robFromSecond = robOptimized(nums, 1, nums.length - 1);
        return Math.max(robFromFirst, robFromSecond);
    }

    private int robOptimized(int[] nums, int indexStart, int size) {
        int previous = 0;
        int current = nums[indexStart];
        final int indexEnd = indexStart + size;
        for (int i = indexStart + 2; i <= indexEnd; i++) {
            int skipCurrent = current;
            int includeCurrent = previous + nums[i - 1];
            previous = current;
            current = Math.max(skipCurrent, includeCurrent);
        }
        return current;
    }

}