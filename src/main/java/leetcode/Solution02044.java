/**
 * 2044. Count Number of Maximum Bitwise-OR Subsets
 * <a href="https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02044 {

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;

        for (int num : nums) {
            maxOr |= num;
        }

        int[] count = new int[1];
        backtrack(nums, 0, 0, maxOr, count);

        return count[0];
    }

    private void backtrack(int[] nums, int index, int currentOr, int maxOr, int[] count) {
        if (currentOr == maxOr) {
            count[0]++;
        }

        for (int i = index; i < nums.length; i++) {
            backtrack(nums, i + 1, currentOr | nums[i], maxOr, count);
        }
    }

}