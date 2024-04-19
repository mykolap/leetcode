package leetcode;

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 * Medium
 */

public class Solution00007 {

    public int reverse(int x) {
        long reversed = 0L;
        while (x != 0) {
            int nextDigit = x % 10;
            reversed = reversed * 10 + nextDigit;
            x = x / 10;
        }
        if (reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) reversed;
    }

}