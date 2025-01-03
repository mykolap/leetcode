/**
 * 2270. Number of Ways to Split Array
 * <a href="https://leetcode.com/problems/number-of-ways-to-split-array">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02270 {

    public int waysToSplitArray(int[] nums) {
        long leftSum = 0;
        long rightSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        int validSplits = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum >= rightSum) {
                validSplits++;
            }
        }

        return validSplits;
    }

}