package leetcode;

/**
 * 330. Patching Array
 * <a href="https://leetcode.com/problems/patching-array/">Web link</a> |
 * Hard
 */

public class Solution00330 {

    public int minPatches(int[] nums, int n) {
        final int numsLen = nums.length;
        int patches = 0;
        int index = 0;
        long numberToReachNext = 1;
        while (numberToReachNext <= n) {
            if (index < numsLen && nums[index] <= numberToReachNext) {
                numberToReachNext += nums[index];
                index++;
            } else {
                numberToReachNext += numberToReachNext;
                patches++;
            }
        }
        return patches;
    }

}