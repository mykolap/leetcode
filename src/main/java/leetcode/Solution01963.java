package leetcode;

/**
 * 1963. Minimum Number of Swaps to Make the String Balanced
 * <a href="https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced">Web link</a> |
 * Medium
 */

public class Solution01963 {

    public int minSwaps(String s) {
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                size++;
            } else if (size > 0) {
                size--;
            }
        }
        return (size + 1) / 2;
    }

}