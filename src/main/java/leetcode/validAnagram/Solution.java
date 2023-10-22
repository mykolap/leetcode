package leetcode.validAnagram;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/valid-anagram/
 * 242. Valid Anagram
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram" Output: true Example 2:
 * <p>
 * Input: s = "rat", t = "car" Output: false
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104 s and t consist of lowercase English letters.
 * <p>
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
@SuppressWarnings("java:S5960")
public class Solution {

    @Test
    void testIsAnagramTrue() {
        String s = "anagram";
        String t = "nagaram";

        assertTrue(new Solution().isAnagramSorting(s, t));
        assertTrue(new Solution().isAnagramMap(s, t));
        assertTrue(new Solution().isAnagram(s, t));
    }

    // Time: O(n log n)
    // Space: O(n)
    public boolean isAnagramSorting(String s, String t) {
        // Check for different lengths, strings not empty by constraints.
        if (s.length() != t.length()) {
            return false;
        }

        // Convert the strings to char arrays.
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        // Sort the char arrays.
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        // Compare the sorted char arrays.
        return Arrays.equals(sChars, tChars);
    }

    // Time: O(n)
    // Space: O(1)
    public boolean isAnagramMap(String s, String t) {
        // Check for different lengths, strings not empty by constraints.
        if (s.length() != t.length()) {
            return false;
        }

        // Create a map for storing frequencies
        Map<Character, Integer> freqMap = new HashMap<>();

        // Iterate over the first string and increment the count of each character.
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
        }

        // Iterate over the second string and decrement the count of each character.
        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) - 1);
        }

        // Iterate over the counts array and check if all counts are 0.
        for (int value : freqMap.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    // Time: O(n)
    // Space: O(1)
    public boolean isAnagram(String s, String t) {
        // Check for different lengths, strings not empty by constraints.
        if (s.length() != t.length()) {
            return false;
        }

        // Create an array to store the counts of each character.
        int[] freqArr = new int[26];

        char currentChar;
        int position;

        // Iterate over the first string and increment the count of each character.
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            position = currentChar - 'a';
            freqArr[position]++;
        }

        // Iterate over the second string and decrement the count of each character.
        for (int i = 0; i < t.length(); i++) {
            currentChar = t.charAt(i);
            position = currentChar - 'a';
            freqArr[position]--;
            if (freqArr[position] < 0) {
                return false;
            }
        }

        // Iterate over the frequency array and check if all counts are 0.
        for (int count : freqArr) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    void testIsAnagramFalse() {
        String s = "rat";
        String t = "car";

        assertFalse(new Solution().isAnagramSorting(s, t));
        assertFalse(new Solution().isAnagramMap(s, t));
        assertFalse(new Solution().isAnagram(s, t));
    }

}
