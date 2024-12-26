/**
 * 494. Target Sum
 * <a href="https://leetcode.com/problems/target-sum">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution00494 {

    public int findTargetSumWays(int[] nums, int target) {
        return findSumRecursively(nums, 0, target);
    }

    private int findSumRecursively(int[] nums, int currentIndex, int target) {
        if (currentIndex == nums.length) {
            return target == 0 ? 1 : 0;
        }
        int sum1 = findSumRecursively(nums, currentIndex + 1, target - nums[currentIndex]);
        int sum2 = findSumRecursively(nums, currentIndex + 1, target + nums[currentIndex]);
        return sum1 + sum2;
    }

    public int findTargetSumWaysDp(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum) {
            return 0;
        }

        int[] dp = new int[2 * totalSum + 1];
        dp[nums[0] + totalSum] = 1;
        dp[-nums[0] + totalSum] += 1;

        for (int index = 1; index < nums.length; index++) {
            int[] next = new int[2 * totalSum + 1];
            for (int sum = -totalSum; sum <= totalSum; sum++) {
                if (dp[sum + totalSum] > 0) {
                    next[sum + nums[index] + totalSum] += dp[sum + totalSum];
                    next[sum - nums[index] + totalSum] += dp[sum + totalSum];
                }
            }
            dp = next;
        }

        return dp[target + totalSum];
    }

}