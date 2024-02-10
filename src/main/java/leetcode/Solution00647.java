package leetcode;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 * 647. Palindromic Substrings
 * Medium
 */
public class Solution00647 {

    // Time complexity: O(n^2)
    // Space complexity: O(n^2)
    public int countSubstrings(String s) {
        // Get the length of the input string
        int n = s.length();

        // Initialize a 2D boolean array for dynamic programming
        // dp[i][j] will be 'true' if the string from index i to j is a palindrome
        boolean[][] dp = new boolean[n][n];

        // Initialize a counter for the number of palindromic substrings
        int palindromeCount = 0;

        // Iterate over all possible lengths for substrings
        for (int substringLength = 1; substringLength <= n; substringLength++) {
            // Iterate over all possible starting indices for substrings of the current length
            for (int startIndex = 0; startIndex <= n - substringLength; startIndex++) {
                // Calculate the ending index for the current substring
                int endIndex = startIndex + substringLength - 1;

                // Check if the characters at the start and end of the substring are the same
                if (s.charAt(startIndex) == s.charAt(endIndex)) {
                    // If the substring length is 2 or less, or the substring excluding the first and last characters is a palindrome,
                    // then the current substring is a palindrome
                    if (substringLength <= 2 || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        palindromeCount++;
                    }
                }
            }
        }

// Return the total count of palindromic substrings
        return palindromeCount;
    }

}