package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1590. Make Sum Divisible by P
 * <a href="https://leetcode.com/problems/make-sum-divisible-by-p">Web link</a> |
 * Medium
 */

public class Solution01590 {

    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int rem = (int) (totalSum % p);
        if (rem == 0) return 0; // If remainder is 0, no subarray needs to be removed

        Map<Integer, Integer> prefixMod = new HashMap<>();
        prefixMod.put(0, -1);  // Initialize to handle full prefix
        long prefixSum = 0;
        int minLength = nums.length;

        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            int currentMod = (int) (prefixSum % p);
            int targetMod = (currentMod - rem + p) % p;

            if (prefixMod.containsKey(targetMod)) {
                minLength = Math.min(minLength, i - prefixMod.get(targetMod));
            }

            prefixMod.put(currentMod, i);
        }

        return minLength == nums.length ? -1 : minLength;
    }

}