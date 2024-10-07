package leetcode;

import java.util.ArrayDeque;

/**
 * 2696. Minimum String Length After Removing Substrings
 * <a href="https://leetcode.com/problems/minimum-string-length-after-removing-substrings">Web link</a> |
 * Easy
 */

public class Solution02696 {

    public int minLength(String s) {
        final int strLen = s.length();
        if (strLen < 2) {
            return strLen;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < strLen; i++) {
            char currentChar = s.charAt(i);
            if (currentChar == 'B' && !stack.isEmpty() && stack.peek() == 'A') {
                stack.pop();
            } else if (currentChar == 'D' && !stack.isEmpty() && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(currentChar);
            }
        }
        return stack.size();
    }

}