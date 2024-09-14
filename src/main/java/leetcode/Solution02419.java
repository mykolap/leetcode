package leetcode;

/**
 * 2419. Longest Subarray With Maximum Bitwise AND
 * <a href="https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and">Web link</a> |
 * Medium
 */

public class Solution02419 {

    public int longestSubarray(int[] nums) {
        int length = nums.length;
        int maxElement = nums[0];
        int currentStreak = 1;
        int longestStreak = 1;

        for (int i = 1; i < length; i++) {
            int value = nums[i];
            if (value == maxElement) {
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else if (value > maxElement) {
                maxElement = value;
                currentStreak = 1;
                longestStreak = 1;
            } else {
                currentStreak = 0;
            }
        }

        return longestStreak;
    }

}