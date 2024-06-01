package leetcode;

/**
 * 260. Single Number III
 * <a href="https://leetcode.com/problems/single-number-iii">Web link</a> |
 * Medium
 */

public class Solution00260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mask = xor & -xor;
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}