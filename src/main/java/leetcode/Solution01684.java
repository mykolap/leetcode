package leetcode;

/**
 * 1684. Count the Number of Consistent Strings
 * <a href="https://leetcode.com/problems/count-the-number-of-consistent-strings">Web link</a> |
 * Easy
 */

public class Solution01684 {

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedChars = new boolean[26];
        for (char ch : allowed.toCharArray()) {
            allowedChars[ch - 'a'] = true;
        }
        int res = 0;
        for (String word : words) {
            if (isWordConsistent(word, allowedChars)) {
                res++;
            }
        }
        return res;
    }

    private static boolean isWordConsistent(String word, boolean[] allowedChars) {
        for (char ch : word.toCharArray()) {
            if (!allowedChars[ch - 'a']) {
                return false;
            }
        }
        return true;
    }
}