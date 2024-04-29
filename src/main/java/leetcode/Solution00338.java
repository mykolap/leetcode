package leetcode;

/**
 * 338. Counting Bits
 * <a href="https://leetcode.com/problems/counting-bits">Web link</a> |
 * Easy
 */

public class Solution00338 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // i & (i - 1) removes the rightmost 1-bit
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    public int[] countBitsClear(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }

}