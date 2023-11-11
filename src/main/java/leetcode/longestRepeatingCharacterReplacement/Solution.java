package leetcode.longestRepeatingCharacterReplacement;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * 424. Longest Repeating Character Replacement
 * <p>
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * <p>
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 */
public class Solution {

    // Time: O(n)
    // Space: O(1)
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26]; // An array to keep track of character counts

        int left = 0; // The left pointer of the sliding window
        int right = 0; // The right pointer of the sliding window
        int maxCount = 0; // Maximum character count within the window

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            counts[rightChar - 'A']++; // Increment the count for the current character
            maxCount = Math.max(maxCount, counts[rightChar - 'A']); // Update the maxCount

            // Check if we need to shrink the window
            final int currentSlidingWindow = right - left;
            final int maxSlidingWindow = maxCount + k;
            if (currentSlidingWindow + 1 > maxSlidingWindow) {
                // Check if the window needs to be shrunk.
                // The condition checks if the number of characters that need replacement is greater than 'k'.
                // If it's true, shrink the window.
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            right++; // Move the right pointer to expand the window
        }

        // Return the length of the longest valid substring, ensuring it doesn't exceed the length of the input string.
        return Math.min(s.length(), maxCount + k);
    }

}
