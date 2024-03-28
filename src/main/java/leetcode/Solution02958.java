package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2958. Length of Longest Subarray With at Most K Frequency
 * https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency
 * Medium
 */

public class Solution02958 {

    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int max = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {
            final int currentElement = nums[right];
            int currentFreq = freq.getOrDefault(currentElement, 0);
            if (currentFreq == k) {
                while (left < right && nums[left] != currentElement) {
                    freq.compute(nums[left], (key, value) -> (value == null) ? 0 : value - 1);
                    left++;
                }
                left++;
            } else {
                freq.put(currentElement, currentFreq + 1);
                max = Math.max(max, right - left + 1);
            }
        }

        return max;
    }

    public int maxSubarrayLengthLessCode(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int max = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {
            int currentElement = nums[right];
            freq.put(currentElement, freq.getOrDefault(currentElement, 0) + 1);

            while (freq.get(currentElement) > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

}