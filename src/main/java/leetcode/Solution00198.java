package leetcode;

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 * <p>
 * Easy
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum
 * amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * <p>
 * Output: 4
 * <p>
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * <p>
 * Output: 12
 * <p>
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1). Total amount you
 * can rob = 2 + 9 + 1 = 12.
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 100
 * <p>
 * 0 <= nums[i] <= 400
 */
public class Solution00198 {

    // Time: O(n)
    // Space: O(1)
    public int rob(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int num : nums) {
            int temp = max1;
            max1 = max2;
            max2 = Math.max(temp + num, max2);
        }

        return max2;
    }

    // Time: O(n)
    // Space: O(n)
    public int robDp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    // Time: O(2^n)
    // Space: O(n)
    public int robBruteForce(int[] nums) {
        return robBruteForce(nums, 0);
    }

    private int robBruteForce(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int robIncludeCurrent = nums[index] + robBruteForce(nums, index + 2);
        int robExcludeCurrent = robBruteForce(nums, index + 1);
        return Math.max(robIncludeCurrent, robExcludeCurrent);
    }

}
