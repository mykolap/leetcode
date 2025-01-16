/**
 * 2425. Bitwise XOR of All Pairings
 * <a href="https://leetcode.com/problems/bitwise-xor-of-all-pairings">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02425 {

    public int xorAllNums(int[] nums1, int[] nums2) {
        int x = 0;
        int y = 0;
        for (int a : nums1) {
            x ^= a;
        }
        for (int b : nums2) {
            y ^= b;
        }
        return (nums1.length % 2 * y) ^ (nums2.length % 2 * x);
    }

}