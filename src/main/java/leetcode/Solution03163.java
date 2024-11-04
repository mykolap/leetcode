package leetcode;

/**
 * 3163. String Compression III
 * <a href="https://leetcode.com/problems/string-compression-iii">Web link</a>
 * Medium
 */

public class Solution03163 {

    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int strLen = word.length();
        char lastChar = word.charAt(0);
        int lastCharCount = 1;
        for (int pos = 1; pos < strLen; pos++) {
            char currentChar = word.charAt(pos);
            if (currentChar == lastChar && lastCharCount < 9) {
                lastCharCount++;
            } else {
                sb.append(lastCharCount).append(lastChar);
                lastChar = currentChar;
                lastCharCount = 1;
            }
        }
        sb.append(lastCharCount).append(lastChar);
        return sb.toString();
    }

}