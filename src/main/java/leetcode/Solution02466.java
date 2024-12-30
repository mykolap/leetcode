/**
 * 2466. Count Ways To Build Good Strings
 * <a href="https://leetcode.com/problems/count-ways-to-build-good-strings">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02466 {

    public int countGoodStrings(int low, int high, int zero, int one) {
        final long MOD = 1_000_000_007L;
        long[] dp = new long[high + 1];
        dp[0] = 1;

        for (int length = 1; length <= high; length++) {
            if (length >= zero) dp[length] = (dp[length] + dp[length - zero]) % MOD;
            if (length >= one) dp[length] = (dp[length] + dp[length - one]) % MOD;
        }

        long result = 0;
        for (int length = low; length <= high; length++) {
            result = (result + dp[length]) % MOD;
        }

        return (int) result;
    }

}