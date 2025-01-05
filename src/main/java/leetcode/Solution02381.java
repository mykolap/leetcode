/**
 * 2381. Shifting Letters II
 * <a href="https://leetcode.com/problems/shifting-letters-ii">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02381 {

    public String shiftingLettersTle(String s, int[][] shifts) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] charIndexes = new int[n];
        for (int i = 0; i < n; i++) {
            charIndexes[i] = chars[i] - 'a';
        }
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int shiftDirection = shift[2];
            for (int i = start; i <= end; i++) {
                if (shiftDirection == 0) {
                    charIndexes[i] = (charIndexes[i] + 25) % 26;
                } else {
                    charIndexes[i] = (charIndexes[i] + 1) % 26;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            chars[i] = (char) ('a' + charIndexes[i]);
        }
        return new String(chars);
    }

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftsAggregated = new int[n];
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int shiftDirection = shift[2];
            if (shiftDirection == 1) {
                shiftsAggregated[start] += 1;
                if (end + 1 < n) {
                    shiftsAggregated[end + 1] -= 1;
                }
            } else {
                shiftsAggregated[start] -= 1;
                if (end + 1 < n) {
                    shiftsAggregated[end + 1] += 1;
                }
            }
        }
        for (int i = 1; i < n; ++i) {
            shiftsAggregated[i] += shiftsAggregated[i - 1];
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            int shift = (shiftsAggregated[i] % 26 + 26) % 26;
            int ch = chars[i] - 'a';
            ch = (ch + shift) % 26;
            chars[i] = (char) ('a' + ch);
        }
        return new String(chars);
    }

}