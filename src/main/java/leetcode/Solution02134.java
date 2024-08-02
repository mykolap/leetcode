package leetcode;

/**
 * 2134. Minimum Swaps to Group All 1's Together II
 * <a href="https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii">Web link</a> |
 * Medium
 */

public class Solution02134 {

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for (int num : nums) {
            if (num == 1) {
                ones++;
            }
        }
        int windowOnes = 0;
        int maxWindowOnes = 0;
        int left = 0;
        int checkRange = n + ones;
        for (int right = 0; right < checkRange; right++) {
            if (nums[right % n] == 1) {
                windowOnes++;
            }
            if (right - left + 1 > ones) {
                windowOnes -= nums[left % n];
                left++;
            }
            maxWindowOnes = Math.max(maxWindowOnes, windowOnes);
        }
        return ones - maxWindowOnes;
    }

}