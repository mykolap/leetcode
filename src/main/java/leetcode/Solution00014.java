package leetcode;

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 * Easy
 */

public class Solution00014 {

    public String longestCommonPrefix(String[] strs) {
        final int strLen = strs.length;
        if (strLen == 0) {
            return "";
        }

        StringBuilder prefixBuilder = new StringBuilder();
        final String firstString = strs[0];
        final int maxPrefix = firstString.length();
        for (int charIndex = 0; charIndex < maxPrefix; charIndex++) {
            char charFromFirstString = firstString.charAt(charIndex);
            for (int strIndex = 1; strIndex < strLen; strIndex++) {
                final String currentString = strs[strIndex];
                if (currentString.length() <= charIndex || currentString.charAt(charIndex) != charFromFirstString) {
                    return prefixBuilder.toString();
                }
            }
            prefixBuilder.append(charFromFirstString);
        }
        return prefixBuilder.toString();
    }

}