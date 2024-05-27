package leetcode;

/**
 * 1608. Special Array With X Elements Greater Than or Equal X
 * <a href="https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x">Web link</a>
 * Easy
 */

public class Solution01608 {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        for (int num : nums) {
            if (num < n) {
                count[num] += 1;
            } else {
                count[n] += 1;
            }
        }
        int totalRight = 0;
        for (int i = n; i > 0; i--) {
            totalRight += count[i];
            if (totalRight == i) {
                return i;
            } else if (totalRight > i) {
                return -1;
            }
        }
        return -1;
    }
}