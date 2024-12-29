/**
 * 1639. Number of Ways to Form a Target String Given a Dictionary
 * https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/
 * Hard
 */

package leetcode;

public class Solution01639 {

    public int numWays(String[] words, String target) {
        final long mod = 1_000_000_007L;
        int n = words[0].length();
        int m = target.length();

        long[][] freq = new long[n][26];
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                freq[i][word.charAt(i) - 'a']++;
            }
        }

        char[] targetCharArr = target.toCharArray();

        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] = (dp[i][j] + (freq[i - 1][targetCharArr[j - 1] - 'a'] * dp[i - 1][j - 1])) % mod;
            }
        }
        return (int) dp[n][m];
    }

}