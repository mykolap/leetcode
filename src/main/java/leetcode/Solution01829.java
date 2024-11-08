/**
 * 1829. Maximum XOR for Each Query
 * <a href="https://leetcode.com/problems/maximum-xor-for-each-query">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution01829 {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] res = new int[n];
        int max = (1 << maximumBit) - 1;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
            res[n - i - 1] = xor ^ max;
        }
        return res;
    }

}