/**
 * 1957. Delete Characters to Make Fancy String
 * <a href="https://leetcode.com/problems/delete-characters-to-make-fancy-string">Web link</a> |
 * Easy
 */

package leetcode;

public class Solution01957 {

    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }

        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append(chars[0])
                .append(chars[1]);

        int strLen = chars.length;
        for (int pos = 2; pos < strLen; pos++) {
            char currentCharacter = s.charAt(pos);
            if (currentCharacter != chars[pos - 1] || currentCharacter != chars[pos - 2]) {
                sb.append(currentCharacter);
            }
        }

        return sb.toString();
    }

}