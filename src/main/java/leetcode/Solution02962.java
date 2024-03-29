package leetcode;

/**
 * 2962. Count Subarrays Where Max Element Appears at Least K Times
 * https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/
 * Medium
 */

public class Solution02962 {

    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long result = 0;
        int left = 0;
        int maxCount = 0;

        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        for (int right = 0; right < n; right++) {
            if (nums[right] == max) {
                maxCount++;
            }

            while (maxCount == k) {
                if (nums[left] == max) {
                    maxCount--;
                }
                left++;
                result += n - right;
            }

        }

        return result;
    }

}