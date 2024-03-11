package leetcode;

/**
 * Problem: 791. Custom Sort String
 * <a href="https://leetcode.com/problems/custom-sort-string">Web link</a>
 * Medium
 */

public class Solution00791 {

    // Time: O(n + m)
    // Space: O(n + m)
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            final int orderIndex = c - 'a';
            final int currentCount = count[orderIndex];
            if (currentCount > 0) {
                sb.repeat(c, currentCount);
                count[orderIndex] = 0;
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            final int orderIndex = c - 'a';
            final int currentCount = count[orderIndex];
            if (currentCount > 0) {
                sb.repeat(c, currentCount);
            }
        }
        return sb.toString();
    }

}