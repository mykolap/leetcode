package leetcode;

import java.util.Arrays;

/**
 * 3068. Find the Maximum Sum of Node Values
 * <a href="https://leetcode.com/problems/find-the-maximum-sum-of-node-values">Web link</a>
 * Hard
 */

public class Solution03068 {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        int[] delta = new int[n];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            delta[i] = (nums[i] ^ k) - nums[i];
            sum += nums[i];
        }

        Arrays.sort(delta);

        for (int i = n - 1; i > 0; i -= 2) {
            int deltaOf2 = delta[i] + delta[i - 1];
            if (deltaOf2 > 0) {
                sum += deltaOf2;
            } else {
                break;
            }
        }

        return sum;
    }

    public long maximumValueSumOptimized(int[] nums, int k, int[][] edges) {
        long sum = 0;
        boolean isOdd = false;
        int maxNegative = Integer.MIN_VALUE;
        int minPositive = Integer.MAX_VALUE;
        for (int num : nums) {
            int delta = (num ^ k) - num;
            if (delta > 0) {
                sum += delta;
                minPositive = Math.min(minPositive, delta);
                isOdd = !isOdd;
            } else {
                maxNegative = Math.max(maxNegative, delta);
            }
            sum += num;
        }

        if (!isOdd) {
            return sum;
        }

        return Math.max(sum - minPositive, sum + maxNegative);
    }

}