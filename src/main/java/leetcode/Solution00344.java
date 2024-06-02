package leetcode;

/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/description/
 * Easy
 */

public class Solution00344 {

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

}