/**
 * 2116. Check if a Parentheses String Can Be Valid
 * <a href="https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution02116 {

    public boolean canBeValid(String s, String locked) {
        int strLen = s.length();
        if (strLen % 2 != 0) {
            return false;
        }

        Deque<Integer> indicesForOpened = new ArrayDeque<>();
        Deque<Integer> indicesForUnlocked = new ArrayDeque<>();

        for (int i = 0; i < strLen; i++) {
            if (locked.charAt(i) == '0') {
                indicesForUnlocked.push(i);
            } else {
                if (s.charAt(i) == '(') {
                    indicesForOpened.push(i);
                } else {
                    if (indicesForOpened.isEmpty()) {
                        if (indicesForUnlocked.isEmpty()) {
                            return false;
                        }
                        indicesForUnlocked.pop();
                    } else {
                        indicesForOpened.pop();
                    }
                }
            }
        }

        while (!indicesForOpened.isEmpty() && !indicesForUnlocked.isEmpty()) {
            if (indicesForOpened.peek() < indicesForUnlocked.peek()) {
                indicesForOpened.pop();
                indicesForUnlocked.pop();
            } else {
                return false;
            }
        }
        return indicesForOpened.isEmpty();
    }

}