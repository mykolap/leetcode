package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/permutation-in-string/
 * 567. Permutation in String
 * <p>
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * <p>
 * Example 2:
 * <p>
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
public class Solution00567 {

    // Time: O(n)
    // Space: O(1)
    public boolean checkInclusionArrayEquals(String s1, String s2) {
        final int s1Length = s1.length();
        final int s2Length = s2.length();

        if (s1Length > s2Length) {
            return false;
        }

        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];

        for (int i = 0; i < s1Length; i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }

        for (int i = s1Length; i < s2Length; i++) {
            if (Arrays.equals(s1Counts, s2Counts)) {
                return true;
            }

            final char leftChar = s2.charAt(i - s1Length);
            final char rightChar = s2.charAt(i);
            if (leftChar != rightChar) {
                s2Counts[leftChar - 'a']--;
                s2Counts[rightChar - 'a']++;
            }
        }

        return Arrays.equals(s1Counts, s2Counts);
    }

    // Time: O(n)
    // Space: O(1)
    public boolean checkInclusion(String s1, String s2) {
        final int s1Length = s1.length();
        final int s2Length = s2.length();

        if (s1Length > s2Length) {
            return false;
        }

        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];
        boolean[] matchedArr = new boolean[26];

        for (int i = 0; i < s1Length; i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }

        int matched = 0; // Number of matched characters
        for (int i = 0; i < 26; i++) {
            if (s1Counts[i] == s2Counts[i]) {
                matched++;
                matchedArr[i] = true;
            }
        }

        for (int i = s1Length; i < s2Length; i++) {
            if (matched == 26) {
                return true;
            }

            final char leftChar = s2.charAt(i - s1Length);
            final char rightChar = s2.charAt(i);
            if (leftChar != rightChar) {
                final int indexLeft = leftChar - 'a';
                final int indexRight = rightChar - 'a';

                s2Counts[indexLeft]--; // Decrement the count for the character at the left pointer
                s2Counts[indexRight]++; // Increment the count for the current character

                if (s1Counts[indexLeft] == s2Counts[indexLeft]) { // if left character count matches
                    if (!matchedArr[indexLeft]) {
                        matched++;
                        matchedArr[indexLeft] = true;
                    }
                } else {
                    if (matchedArr[indexLeft]) {
                        matched--;
                        matchedArr[indexLeft] = false;
                    }
                }

                if (s1Counts[indexRight] == s2Counts[indexRight]) { // if right character count matches
                    if (!matchedArr[indexRight]) {
                        matched++;
                        matchedArr[indexRight] = true;
                    }
                } else {
                    if (matchedArr[indexRight]) {
                        matched--;
                        matchedArr[indexRight] = false;
                    }
                }
            }
        }

        return matched == 26;
    }

}
