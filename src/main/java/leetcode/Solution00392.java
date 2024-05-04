package leetcode;

/**
 * 392. Is Subsequence
 * <a href="https://leetcode.com/problems/is-subsequence">Web link</a>
 * Easy
 */

public class Solution00392 {

    public boolean isSubsequence(String s, String t) {
        int positionT = 0;
        int positionS = 0;
        final int sLen = s.length();
        final int tLen = t.length();
        while (positionS < sLen && positionT < tLen) {
            if (s.charAt(positionS) == t.charAt(positionT)) {
                positionS++;
            }
            positionT++;
        }
        return positionS == sLen;
    }

}