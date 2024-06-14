package leetcode;

import java.util.Arrays;

/**
 * 945. Minimum Increment to Make Array Unique
 * <a href="https://leetcode.com/problems/minimum-increment-to-make-array-unique/">Web link</a> |
 * Medium
 */

public class Solution00945 {

    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int moves = 0;
        int prev = nums[0];
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            if (curr <= prev) {
                moves += prev - curr + 1;
                prev++;
            } else {
                prev = curr;
            }
        }
        return moves;
    }

}