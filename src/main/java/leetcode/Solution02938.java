package leetcode;

/**
 * 2938. Separate Black and White Balls
 * <a href="https://leetcode.com/problems/separate-black-and-white-balls">Web link</a> |
 * Medium
 */

public class Solution02938 {

    public long minimumSteps(String s) {
        long swaps = 0;
        int blackPosition = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                swaps += blackPosition;
            } else {
                ++blackPosition;
            }
        }
        return swaps;
    }

}