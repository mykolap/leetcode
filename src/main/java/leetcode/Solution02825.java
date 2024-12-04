/**
 * 2825. Make String a Subsequence Using Cyclic Increments
 * <a href="https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02825 {

    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            final char ch1 = str1.charAt(i);
            final char ch2 = str2.charAt(j);
            if (ch1 == ch2 ||
                    ch1 == (ch2 == 'a' ? 'z' : (char) (ch2 - 1))) {
                j++;
            }
            i++;
        }

        return j == str2.length();
    }


}