package leetcode;

/**
 * 2864. Maximum Odd Binary Number
 * https://leetcode.com/problems/maximum-odd-binary-number/
 * Easy
 */

public class Solution02864 {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        if (n == 1) {
            return s;
        }
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count1++;
            }
        }
        return new StringBuilder()
                .repeat("1", count1 - 1)
                .repeat("0", n - count1)
                .append("1")
                .toString();
    }

}