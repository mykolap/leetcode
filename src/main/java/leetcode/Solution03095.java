package leetcode;

/**
 * 3095. Shortest Subarray With OR at Least K I
 * https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/
 * Easy
 */

public class Solution03095 {

    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        for (int left = 0; left < n; left++) {
            long or = 0;
            for (int right = left; right < n; right++) {
                or |= nums[right];
                if (or >= k) {
                    min = Math.min(min, right - left + 1);
                    break;
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
