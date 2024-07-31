package leetcode;

/**
 * 1105. Filling Bookcase Shelves
 * <a href="https://leetcode.com/problems/filling-bookcase-shelves">Web link</a>
 * Medium
 */

public class Solution01105 {

    public int minHeightShelves(int[][] books, int shelfWidth) {
        final int n = books.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int currentShelfWidth = 0;
            int currentShelfHeight = 0;
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                final int[] currentBook = books[j];
                final int currentBookWidth = currentBook[0];
                currentShelfWidth += currentBookWidth;
                if (currentShelfWidth > shelfWidth) {
                    break;
                }
                final int currentBookHeight = currentBook[1];
                currentShelfHeight = Math.max(currentShelfHeight, currentBookHeight);
                dp[i] = Math.min(dp[i], dp[j] + currentShelfHeight);
            }
        }
        return dp[n];
    }

}