package leetcode;

/**
 * 2914. Minimum Number of Changes to Make Binary String Beautiful
 * <a href="https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful">Web link</a> |
 * Medium
 */

public class Solution02914 {

    public int minChanges(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i += 2) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                count++;
            }
        }
        return count;
    }

}