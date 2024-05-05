package leetcode;

/**
 * https://leetcode.com/problems/decode-ways/
 * 91. Decode Ways
 * Medium
 */
public class Solution00091 {

    // Time: O(2^n)
    // Space: O(n)
    public int numDecodingsRecursion(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        return numDecodings(0, s);
    }

    private int numDecodings(int p, String s) {
        int n = s.length();
        if (p == n) {
            return 1;
        }

        // If the current character is '0', return 0.
        if (s.charAt(p) == '0') {
            return 0;
        }

        int res = numDecodings(p + 1, s);

        if (p < n - 1 &&
            (s.charAt(p) == '1' || (s.charAt(p) == '2' && s.charAt(p + 1) <= '6'))) {
            res += numDecodings(p + 2, s);
        }

        return res;
    }

    // Time: O(n)
    // Space: O(n)
    public int numDecodingsDp(String s) {
        // Check for invalid inputs.
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        // Iterate over the string.
        for (int i = 2; i <= n; i++) {
            // Get the current character.
            char currentChar = s.charAt(i - 1);

            // Get the previous character.
            char previousChar = s.charAt(i - 2);

            // If the current character is 0, then we can't decode it.
            dp[i] = currentChar == '0' ? 0 : dp[i - 1];

            // If the previous character is 1 or 2 and the current character is less than or equal to 6,
            // then we can decode it.
            if (previousChar == '1' || (previousChar == '2' && currentChar <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        // Return the number of ways to decode the string.
        return dp[n];
    }

    // Time: O(n)
    // Space: O(1)
    public int numDecodings(String s) {
        // Check for invalid inputs.
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();

        int currentWay = s.charAt(0) == '0' ? 0 : 1;
        int previousWay = currentWay;
        int beforePreviousWay = currentWay;

        // Iterate over the string.
        for (int i = 1; i < n; i++) {
            // Get the current character.
            char currentChar = s.charAt(i);

            // Get the previous character.
            char previousChar = s.charAt(i - 1);

            // If the current character is 0, then we can't decode it.
            currentWay = currentChar == '0' ? 0 : previousWay;

            // If the previous character is 1 or 2 and the current character is less than or equal to 6,
            // then we can decode it.
            if (previousChar == '1' || (previousChar == '2' && currentChar <= '6')) {
                currentWay += beforePreviousWay;
            }

            beforePreviousWay = previousWay;
            previousWay = currentWay;
        }

        // Return the number of ways to decode the string.
        return currentWay;
    }

}
