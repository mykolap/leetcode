package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 * 1347. Minimum Number of Steps to Make Two Strings Anagram
 * Medium
 * ---
 * Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another
 * character.
 * Return the minimum number of steps to make t an anagram of s.
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 * Example 1:
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 * Example 2:
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 * Example 3:
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams.
 * <p>
 * Constraints:
 * 1 <= s.length <= 50000
 * s.length == t.length
 * s and t contain lower-case English letters only.
 */
public class Solution01347 {

    // Time: O(n)
    // Space: O(n)
    public int minSteps(String s, String t) {
        int len = s.length();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            freqMap.merge(s.charAt(i), 1, Integer::sum);
            freqMap.merge(t.charAt(i), -1, Integer::sum);
        }
        return freqMap.values()
                .stream()
                .mapToInt(Integer::intValue)
                .filter(i -> i > 0)
                .sum();
    }

}
