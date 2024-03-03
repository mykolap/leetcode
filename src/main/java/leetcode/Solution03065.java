package leetcode;

import java.util.Arrays;

/**
 * 3065. Minimum Operations to Exceed Threshold Value I
 * https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/
 * Easy
 */
public class Solution03065 {

    // Time: O(nlogn)
    // Space: O(1)
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= k) {
                return i;
            }
        }
        return n;
    }
}
