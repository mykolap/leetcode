package leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 5. Longest Palindromic Substring
 * Medium
 */
public class Solution00005 {

    // Time: O(n^3)
    // Space: O(1)
    public String longestPalindromeBruteforce(String s) {
        String result = "";
        for (int left = 0; left < s.length(); left++) {
            for (int right = left + 1; right <= s.length(); right++) {
                String substring = s.substring(left, right);
                if (isPalindrome(substring) && substring.length() > result.length()) {
                    result = substring;
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Time: O(n^2)
    // Space: O(1)
    public String longestPalindromeExpandAroundCenter(String s) {
        int[] result = new int[]{0, 1}; // left index and length
        for (int center = 0; center < s.length(); center++) {
            // odd length
            int[] palindromeOdd = expandAroundCenter(s, center, center);
            if (palindromeOdd[1] > result[1]) {
                result = palindromeOdd;
            }
            // even length
            int[] palindromeEven = expandAroundCenter(s, center, center + 1);
            if (palindromeEven[1] > result[1]) {
                result = palindromeEven;
            }
        }

        return s.substring(result[0], result[0] + result[1]);
    }

    private int[] expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }

            left--;
            right++;
        }

        final int outputLeft = left + 1;
        final int outputLength = right - left - 1;
        return new int[]{outputLeft, outputLength};
        // for left/right input 0, after first iteration left/right will be -1/1,
        // so to get left - we have to add 1, and get index 0 left + 1 = -1 + 1 = 0
        // and for the length - right - left - 1 = 1 - (-1) - 1 = 1
    }

    // Time: O(n^2)
    // Space: O(1)
    public String longestPalindromeDynamicProgramming(String s) {
        int resultLeft = 0;
        int resultLength = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int right = 0; right < s.length(); right++) {
            int left = right;
            dp[left][right] = true;
        }

        for (int right = 1; right < s.length(); right++) {
            int left = right - 1;
            if (s.charAt(left) == s.charAt(right)) {
                dp[left][right] = true;
                resultLength = 2;
                resultLeft = left;
            }
        }

        for (int right = 2; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    if (right - left + 1 > resultLength) {
                        resultLength = right - left + 1;
                        resultLeft = left;
                    }
                }
            }
        }

        return s.substring(resultLeft, resultLeft + resultLength);
    }

}
