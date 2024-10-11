package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 962. Maximum Width Ramp
 * <a href="https://leetcode.com/problems/maximum-width-ramp">Web link</a>
 * Medium
 */

public class Solution00962 {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }
        int maxWidth = 0;
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[j] >= nums[stack.peek()]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            }
        }
        return maxWidth;
    }
}