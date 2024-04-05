package leetcode;

/**
 * 1544. Make The String Great
 * https://leetcode.com/problems/make-the-string-great/
 * Easy
 */

public class Solution01544 {

    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (char currentCharacter : s.toCharArray()) {
            if (sb.isEmpty()) {
                sb.append(currentCharacter);
            } else {
                final char lastCharInBuilder = sb.charAt(sb.length() - 1);
                final int asciiDifference = Math.abs(lastCharInBuilder - currentCharacter);
                if (asciiDifference == 32) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(currentCharacter);
                }
            }
        }
        return sb.toString();
    }

}