package leetcode;

/**
 * 664. Strange Printer
 * <a href="https://leetcode.com/problems/strange-printer">Web link</a>
 * Hard
 */

public class Solution00664 {

    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        return count(s, dp, 0, n - 1);
    }

    private int count(String s, int[][] dp, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int res = count(s, dp, i, j - 1) + 1;
        for (int k = i; k < j; k++) {
            if (s.charAt(k) == s.charAt(j)) {
                res = Math.min(res, count(s, dp, i, k) + count(s, dp, k + 1, j - 1));
            }
        }
        dp[i][j] = res;
        return res;
    }

}