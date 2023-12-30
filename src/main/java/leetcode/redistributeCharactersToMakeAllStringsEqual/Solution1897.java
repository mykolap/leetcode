package leetcode.redistributeCharactersToMakeAllStringsEqual;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
 * 1897. Redistribute Characters to Make All Strings Equal
 * <p>
 * You are given an array of strings words (0-indexed).
 * <p>
 * In one operation, pick two distinct indices i and j, where words[i] is a non-empty string,
 * and move any character from words[i] to any position in words[j].
 * <p>
 * Return true if you can make every string in words equal using any number of operations, and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["abc","aabc","bc"]
 * Output: true
 * Explanation: Move the first 'a' in words[1] to the front of words[2],
 * to make words[1] = "abc" and words[2] = "abc".
 * All the strings are now equal to "abc", so return true.
 * <p>
 * Example 2:
 * <p>
 * Input: words = ["ab","a"]
 * Output: false
 * Explanation: It is impossible to make all the strings equal using the operation.
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of lowercase English letters.
 */
public class Solution1897 {

    // Time: O(n * m)
    // Space: O(1)
    public boolean makeEqual(String[] words) {
        // Count the number of occurrences of each character.
        Map<Character, Integer> charCounts = new HashMap<>();
        for (String word : words) {
            word.chars().forEach(c -> charCounts.merge((char) c, 1, Integer::sum));
        }

        // Return whether the number of occurrences of each character is divisible by the number of words.
        for (int count : charCounts.values()) {
            if (count % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
