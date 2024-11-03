/**
 * 796. Rotate String
 * <a href="https://leetcode.com/problems/rotate-string">Web link</a> |
 * Easy
 */
package leetcode;

public class Solution00796 {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }

}