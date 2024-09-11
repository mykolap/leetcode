package leetcode;

/**
 * 2220. Minimum Bit Flips to Convert Number
 * <a href="https://leetcode.com/problems/minimum-bit-flips-to-convert-number">Web link</a> |
 * Easy
 */

public class Solution02220 {

    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }

}