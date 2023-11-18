package leetcode.minimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * 76. Minimum Window Substring
 * <p>
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * <p>
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 * <p>
 * <p>
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class Solution {

    // Time: O(n)
    // Space: O(n)
    public String minWindow(String s, String t) {
        // Create an array to store the start and end indices of the minimum window substring.
        int[] result = new int[2];
        // Create a hash map to store the count of each character in the string t.
        Map<Character, Integer> charsOfT = new HashMap<>();
        // Create a hash map to store the count of each character in the current window of the string s.
        Map<Character, Integer> windowOfS = new HashMap<>();

        // Iterate over the characters in the string t and add them to the hash map charsOfT, with a count of 1 for each character.
        t.chars().forEach(ch -> charsOfT.merge((char) ch, 1, Integer::sum));

        // Initialize the minimum window length.
        int min = Integer.MAX_VALUE;

        // Initialize the number of distinct characters in the string t that need to be present in the minimum window substring.
        int need = charsOfT.size();

        // Initialize the number of distinct characters in the current window of the string s that are present in the string t.
        int have = 0;

        // Initialize the start and end indices of the current window of the string s.
        int left = 0;
        final int length = s.length();

        // Iterate over the characters in the string s.
        for (int right = 0; right < length; right++) {
            // Get the current character in the string s.
            final char rightChar = s.charAt(right);

            // Check if the current character is present in the string t.
            Integer countInT = charsOfT.get(rightChar);
            if (countInT == null) {
                // Continue to the next iteration.
                continue;
            }

            // Update the count of the current character in the current window of the string s.
            windowOfS.merge(rightChar, 1, Integer::sum);

            // Check if the count of the current character in the current window of the string s is equal to the count of that character in the string t.
            if (countInT.equals(windowOfS.get(rightChar))) {
                // Increment the have variable.
                have++;
            }

            // While the have variable is equal to the need variable, iterate.
            while (have == need) {
                // Calculate the length of the current window.
                final int minCandidate = right - left + 1;

                // Check if the length of the current window is less than the minimum window length.
                if (minCandidate < min) {
                    // Update the minimum window length.
                    min = minCandidate;

                    // Update the start and end indices of the minimum window substring.
                    result[0] = left;
                    result[1] = right;
                }

                // Get the character at the left index of the current window.
                final char leftChar = s.charAt(left);

                // Check if the character at the left index of the current window is present in the string t.
                Integer countInT2 = charsOfT.get(leftChar);
                if (countInT2 != null) {
                    // Update the count of the character at the left index of the current window in the current window of the string s.
                    windowOfS.merge(leftChar, -1, Integer::sum);

                    // Check if the count of the character at the left index of the current window in the current window of the string s is less than the count of that character in the string t.
                    if (windowOfS.get(leftChar) < countInT2) {
                        // Decrement the have variable.
                        have--;
                    }
                }

                // Increment the left index of the current window.
                left++;
            }
        }

        // Return the minimum window substring, or an empty string if no minimum window substring is found.
        return min == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }

    // Time: O(n)
    // Space: O(n)
    public String minWindowArr(String s, String t) {
        int[] need = new int[128];
        int total = 0;
        for (char c : t.toCharArray()) {
            need[c]++;
            total++;
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int winStart = 0;
        int winLength = Integer.MAX_VALUE;
        int[] window = new int[128];
        int strLen = s.length();
        while (right < strLen) {
            char c = s.charAt(right);
            right++;
            if (need[c] > 0) {
                window[c]++;
                if (window[c] <= need[c]) {
                    valid++;
                }
            }
            while (valid == total) {
                if (right - left < winLength) {
                    winStart = left;
                    winLength = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need[d] > 0) {
                    if (window[d] <= need[d]) {
                        valid--;
                    }
                    window[d]--;
                }
            }
        }
        return winLength == Integer.MAX_VALUE ? "" : s.substring(winStart, winStart + winLength);
    }

}