package leetcode;

/**
 * 1653. Minimum Deletions to Make String Balanced
 * <a href="https://leetcode.com/problems/minimum-deletions-to-make-string-balanced">Web link</a> |
 * Medium
 */

public class Solution01653 {

    public int minimumDeletions(String s) {
        int n = s.length();
        int aCountRight = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                aCountRight++;
            }
        }

        int bCountLeft = 0;
        int minDeletions = n;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                aCountRight--;
            }
            minDeletions = Math.min(minDeletions, bCountLeft + aCountRight);
            if (ch == 'b') {
                bCountLeft++;
            }
        }
        return minDeletions;
    }

    public int minimumDeletionsOptimized(String s) {
        int countB = 0;
        int minDeletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                minDeletions = Math.min(minDeletions + 1, countB);
            } else {
                countB++;
            }
        }

        return minDeletions;
    }

}