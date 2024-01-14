package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close/
 * 1657. Determine if Two Strings Are Close
 * Medium
 * <p>
 * Share
 * Two strings are considered close if you can attain one from the other using the following operations:
 * <p>
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character,
 * and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 * <p>
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 * Example 2:
 * <p>
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 * Example 3:
 * <p>
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 * Example 4:
 * <p>
 * Input: word1 = "cabbba", word2 = "aabbss"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any amount of operations.
 * <p>
 * Constraints:
 * <p>
 * 1 <= word1.length, word2.length <= 105
 * word1 and word2 contain only lowercase English letters.
 */
public class Solution01657 {

    // Time: O(n)
    // Space: O(1)
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            count1[word1.charAt(i) - 'a']++;
            count2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] == 0 && count2[i] != 0 || count1[i] != 0 && count2[i] == 0) {
                return false;
            }
        }

        int[] freq1 = new int[word1.length() + 1];
        int[] freq2 = new int[word2.length() + 1];
        for (int i = 0; i < 26; i++) {
            freq1[count1[i]]++;
            freq2[count2[i]]++;
        }

        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    // Time: O(n)
    // Space: O(1)
    public boolean closeStrings2(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        // Count frequency of each character in both words
        for (int i = 0; i < word1.length(); i++) {
            f1[word1.charAt(i) - 'a']++;
            f2[word2.charAt(i) - 'a']++;
        }

        // Check if the set of characters is the same for both words
        for (int i = 0; i < 26; i++) {
            if ((f1[i] == 0 && f2[i] != 0) || (f1[i] != 0 && f2[i] == 0))
                return false;
        }

        // Sort frequency arrays
        Arrays.sort(f1);
        Arrays.sort(f2);

        // Check if the frequency of each character is the same
        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i])
                return false;
        }

        return true;
    }

}
