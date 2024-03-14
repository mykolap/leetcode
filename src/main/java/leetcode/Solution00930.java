package leetcode;

/**
 * 930. Binary Subarrays With Sum
 * <a href="https://leetcode.com/problems/binary-subarrays-with-sum">Web link</a>
 * Medium
 */

public class Solution00930 {

    // Time: O(n)
    // Space: O(n)
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 1;
        int sum = 0;
        int result = 0;
        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                result += prefixSum[sum - goal];
            }
            prefixSum[sum]++;
        }
        return result;
    }

    public int numSubarraysWithSumAlt(int[] nums, int goal) {
        int x = solve(nums, goal);
        int y = solve(nums, goal - 1);
        return x - y;
    }

    public int solve(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int s = 0;
        int e = 0;
        int sum = 0;
        int ans = 0;
        while (e < nums.length) {
            sum += nums[e];
            while (sum > k && s < nums.length) {
                sum -= nums[s];
                s++;
            }
            if (sum <= k) {
                ans += e - s + 1;
            }
            e++;
        }
        return ans;
    }
}