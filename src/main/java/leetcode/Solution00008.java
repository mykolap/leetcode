package leetcode;

/**
 * 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 * Medium
 */

public class Solution00008 {

    public int myAtoi(String s) {
        int currentIndex = 0;
        int n = s.length();
        while (currentIndex < n && s.charAt(currentIndex) == ' ') {
            currentIndex++;
        }
        if (currentIndex == n) {
            return 0;
        }
        int sign = 1;
        if (s.charAt(currentIndex) == '+' || s.charAt(currentIndex) == '-') {
            sign = s.charAt(currentIndex) == '+' ? 1 : -1;
            currentIndex++;
        }
        long num = 0;
        while (currentIndex < n && Character.isDigit(s.charAt(currentIndex))) {
            final int currentDigit = s.charAt(currentIndex) - '0';
            num = num * 10 + currentDigit;
            if (num > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            currentIndex++;
        }
        return (int) num * sign;
    }

}