package leetcode;

/**
 * Problem: 268. Missing Number
 * Source: https://leetcode.com/problems/missing-number/
 * Easy
 */

public class Solution00268 {

    // Time: O(n)
    // Space: O(1)
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = n;
        for (int i = 0; i < n; i++) {
            result = result + i - nums[i];
        }
        return result;
    }

}
