/**
 * 2516. Take K of Each Character From Left and Right
 * <a href="https://leetcode.com/problems/take-k-of-each-character-from-left-and-right">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02516 {

    public int takeCharacters(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int[] count = new int[3];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        if (invalid(count, k)) {
            return -1;
        }

        int begin = 0;
        int end = 0;
        int max = -1;
        while (end < s.length()) {
            count[s.charAt(end) - 'a']--;
            while (invalid(count, k)) {
                count[s.charAt(begin++) - 'a']++;
            }
            max = Math.max(max, end - begin + 1);
            end++;
        }
        return s.length() - max;
    }

    private boolean invalid(int[] count, int k) {
        for (int i : count) {
            if (i < k) return true;
        }
        return false;
    }

}