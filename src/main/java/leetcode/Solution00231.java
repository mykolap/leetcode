package leetcode;

/**
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/
 * Easy
 */
public class Solution00231 {

    // Time: O(1)
    // Space: O(1)
    public boolean isPowerOfTwoBinary(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Time: O(1)
    // Space: O(1)
    public boolean isPowerOfTwoBitCount(int n) {
        return n > 0 && (Integer.bitCount(n) == 1);
    }

}