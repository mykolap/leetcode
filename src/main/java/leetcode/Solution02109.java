/**
 * 2109. Adding Spaces to a String
 * <a href="https://leetcode.com/problems/adding-spaces-to-a-string">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02109 {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        if (spaces[0] > 0) {
            sb.append(s.substring(0, spaces[0]));
        }
        int currentPosition = spaces[0];
        for (int i = 1; i < spaces.length; i++) {
            int nextPosition = spaces[i];
            sb.append(" ")
                    .append(s.substring(currentPosition, nextPosition));
            currentPosition = nextPosition;
        }
        sb.append(" ")
                .append(s.substring(currentPosition));
        return sb.toString();
    }

}