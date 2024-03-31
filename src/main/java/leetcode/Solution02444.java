package leetcode;

/**
 * 2444. Count Subarrays With Fixed Bounds
 * <a href="https://leetcode.com/problems/count-subarrays-with-fixed-bounds">Web link</a> |
 * Hard
 */

public class Solution02444 {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int invalidIndex = -1;
        int minIndex = -1;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];

            if (currentNum < minK || currentNum > maxK) {
                invalidIndex = i;
            }

            if (currentNum == minK) {
                minIndex = i;
            }

            if (currentNum == maxK) {
                maxIndex = i;
            }

            int left = Math.min(minIndex, maxIndex);
            if (left > invalidIndex) {
                result += left - invalidIndex;
            }
        }

        return result;
    }

}