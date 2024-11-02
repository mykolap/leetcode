/**
 * 2490. Circular Sentence
 * <a href="https://leetcode.com/problems/circular-sentence">Web link</a> |
 * Easy
 */

package leetcode;

public class Solution02490 {

    public boolean isCircularSentence(String sentence) {
        int strLen = sentence.length();
        if (sentence.charAt(0) != sentence.charAt(strLen - 1)) {
            return false;
        }
        char endChar = '-';
        boolean previousCharIsSpace = false;
        for (int i = 0; i < strLen; i++) {
            if (sentence.charAt(i) == ' ') {
                previousCharIsSpace = true;
                continue;
            }
            if (previousCharIsSpace) {
                if (endChar != sentence.charAt(i)) {
                    return false;
                }
                previousCharIsSpace = false;
            }
            endChar = sentence.charAt(i);
        }
        return true;
    }

}