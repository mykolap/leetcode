package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 * 1624. Largest Substring Between Two Equal Characters
 * <p>
 * Given a string s, return the length of the longest substring between two equal characters,
 * excluding the two characters. If there is no such substring return -1.
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aa"
 * Output: 0
 * Explanation: The optimal substring here is an empty substring between the two 'a's.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "abca"
 * Output: 2
 * Explanation: The optimal substring here is "bc".
 * <p>
 * Example 3:
 * <p>
 * Input: s = "cbzxy"
 * Output: -1
 * Explanation: There are no characters that appear twice in s.
 * <p>
 * Example 4:
 * <p>
 * Input: s = "cabbac"
 * Output: 4
 * Explanation: The optimal substring here is "abba". Other non-optimal substrings include
 * "bb" and "".
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 300
 * s contains only lowercase English letters.
 */
public class Solution01624 {

    // Time: O(n^2)
    // Space: O(1)
    public int maxLengthBetweenEqualCharactersBruteforce(String s) {
        int result = -1;
        for (int left = 0; left < s.length(); left++) {
            for (int right = left + 1; right < s.length(); right++) {
                if (s.charAt(left) == s.charAt(right)) {
                    result = Math.max(result, right - left - 1);
                }
            }
        }

        return result;
    }

    // Time: O(n)
    // Space: O(n)
    public int maxLengthBetweenEqualCharactersMap(String s) {
        int result = -1;
        Map<Character, Integer> leftMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            Integer left = leftMap.get(ch);
            if (left == null) {
                leftMap.put(ch, right);
            } else {
                result = Math.max(result, right - left - 1);
            }
        }
        return result;
    }

    // Time: O(n)
    // Space: O(1)
    public int maxLengthBetweenEqualCharactersArray(String s) {
        // Initialize the result to -1.
        int result = -1;
        // Initialize the array of the first occurrences of each character to -1.
        int[] leftArray = new int[26];
        Arrays.fill(leftArray, -1);

        // Iterate over the characters of the string.
        for (int i = 0; i < s.length(); i++) {
            // Get the index of the current character.
            int index = s.charAt(i) - 'a';
            // If the first occurrence of the current character is not set, set it.
            if (leftArray[index] == -1) {
                leftArray[index] = i;
            } else {
                // Otherwise, update the result if needed.
                result = Math.max(result, i - leftArray[index] - 1);
            }
        }

        return result;
    }
}
