package leetcode;

/**
 * 2000. Reverse Prefix of Word
 * <a href="https://leetcode.com/problems/reverse-prefix-of-word">Web link</a> |
 * Easy
 */

public class Solution02000 {

    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        if (i == -1) {
            return word;
        }
        return new StringBuilder(word.substring(0, i + 1))
                .reverse()
                .append(word.substring(i + 1))
                .toString();
    }

}