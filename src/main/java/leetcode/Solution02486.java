package leetcode;

/**
 * 2486. Append Characters to String to Make Subsequence
 * <a href="https://leetcode.com/problems/append-characters-to-string-to-make-subsequence">Web link</a> |
 * Medium
 */

public class Solution02486 {

    public int appendCharacters(String s, String t) {
        int firstMatch = s.indexOf(t.charAt(0));
        final int tLen = t.length();
        if (firstMatch < 0) {
            return tLen;
        }
        int posT = 1;
        int posS = firstMatch + 1;
        int matched = 1;
        final int sLen = s.length();
        while (posS < sLen && posT < tLen) {
            if (s.charAt(posS) == t.charAt(posT)) {
                matched++;
                posT++;
            }
            posS++;
        }
        return tLen - matched;
    }

}