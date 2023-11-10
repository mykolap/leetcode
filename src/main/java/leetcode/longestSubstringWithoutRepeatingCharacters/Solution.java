package leetcode.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * <p>
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * <p>
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * <p>
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Example 4:
 * <p>
 * Input: s = ""
 * Output: 0
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class Solution {

    // Time: O(n)
    // Space: O(n)
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;

        Set<Character> seen = new HashSet<>();

        int result = 0;

        final int length = s.length();
        while (right < length) {
            Character rightChar = s.charAt(right);
            if (seen.contains(rightChar)) {
                seen.remove(s.charAt(left));
                left++;
            } else {
                seen.add(rightChar);
                right++;
                result = Math.max(result, right - left);
            }
        }

        return result;
    }

    // Time: O(n)
    // Space: O(1)
    public int lengthOfLongestSubstringIntArr(String s) {
        int left = 0;
        int right = 0;

        int[] seen = new int[128];

        int result = 0;

        final int length = s.length();
        while (right < length) {
            char rightChar = s.charAt(right);
            if (seen[rightChar] > 0) {
                seen[s.charAt(left)]--;
                left++;
            } else {
                seen[rightChar]++;
                right++;
                result = Math.max(result, right - left);
            }
        }

        return result;
    }
}
