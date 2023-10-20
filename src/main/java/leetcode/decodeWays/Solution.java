package leetcode.decodeWays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/decode-ways/
 * 91. Decode Ways
 * <p>
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * <p>
 * 'A' -> "1" 'B' -> "2" ... 'Z' -> "26" To decode an encoded message, all the digits must be grouped then mapped
 * back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can
 * be mapped into:
 * <p>
 * "AAJF" with the grouping (1 1 10 6) "KJF" with the grouping (11 10 6) Note that the grouping (1 11 06) is
 * invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * <p>
 * Given a string s containing only digits, return the number of ways to decode it.
 * <p>
 * The answer is guaranteed to fit in a 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "12" Output: 2 Explanation: "12" could be decoded as "AB" (1 2) or "L" (12). Example 2:
 * <p>
 * Input: s = "226" Output: 3 Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2
 * 2 6). Example 3:
 * <p>
 * Input: s = "0" Output: 0 Explanation: There is no character that is mapped to a number starting with 0. The
 * only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0. Hence, there are no
 * valid ways to decode this since all digits need to be mapped. Example 4:
 * <p>
 * Input: s = "06" Output: 0 Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is
 * different from "06").
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100 s contains only digits and may contain leading zero(s).
 */
@SuppressWarnings("java:S5960")
public class Solution {

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

    @ParameterizedTest
    @CsvSource({
            "12, 2",
            "226, 3",
            "0, 0",
            "06, 0",
            "901, 0",
            "10, 1",
            "2101, 1",
            "21012, 2",
            "210123, 3",
            "2101234567890, 0",
            "21012345678901, 0",
    })
    public void test(String input, int expected) {
        assertAll(
                () -> assertEquals(expected, new Solution().numDecodingsRecursion(input)),
                () -> assertEquals(expected, new Solution().numDecodingsDp(input)),
                () -> assertEquals(expected, new Solution().numDecodings(input))
        );
    }

}
