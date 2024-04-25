package leetcode;

import java.util.Arrays;

/**
 * 2370. Longest Ideal Subsequence
 * <a href="https://leetcode.com/problems/longest-ideal-subsequence">Web link</a> |
 * Medium
 */

public class Solution02370 {

    public int longestIdealString(String s, int k) {
        // Get the length of the input string
        int stringLength = s.length();

        // Initialize a dynamic programming array to keep track of the longest ideal subsequence for each character
        int[] longestIdealSubsequenceForEachChar = new int[26];

        // Iterate over each character in the input string
        for (int i = 0; i < stringLength; i++) {
            // Convert the current character to its corresponding index in the alphabet (0-25)
            int currentCharIndex = s.charAt(i) - 'a';

            // Initialize a variable to keep track of the maximum length of the ideal subsequence found so far
            int maxLengthSoFar = 0;

            // Iterate over each possible character in the alphabet
            for (int j = 0; j < 26; j++) {
                // If the absolute difference between the current character and the character represented by 'j' is less than or equal to 'k'
                if (Math.abs(j - currentCharIndex) <= k) {
                    // Update the maximum length of the ideal subsequence found so far
                    maxLengthSoFar = Math.max(longestIdealSubsequenceForEachChar[j], maxLengthSoFar);
                }
            }

            // Update the longest ideal subsequence for the current character
            longestIdealSubsequenceForEachChar[currentCharIndex] = Math.max(maxLengthSoFar + 1, longestIdealSubsequenceForEachChar[currentCharIndex]);
        }

        // Initialize a variable to keep track of the result
        int longestIdealSubsequence = 0;

        // Iterate over the dynamic programming array to find the maximum length of the ideal subsequence
        for (int longestSubsequence : longestIdealSubsequenceForEachChar) {
            longestIdealSubsequence = Math.max(longestSubsequence, longestIdealSubsequence);
        }

        // Return the maximum length of the ideal subsequence
        return longestIdealSubsequence;
    }

    public int longestIdealStringSimple(String s, int k) {
        int[] dp = new int[26];

        for (char c : s.toCharArray()) {
            int max = 0;
            int idx = c - 'a';
            for (int j = 0; j < 26; j++) {
                if (Math.abs(j - idx) <= k) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[idx] = Math.max(max + 1, dp[idx]);
        }

        return Arrays.stream(dp).max().orElse(0);
    }

}
