package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * 451. Sort Characters By Frequency
 * Medium
 * <p>
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 * <p>
 * Return the sorted string. If there are multiple answers, return any of them.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p>
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 * 105
 * s consists of uppercase and lowercase English letters and digits.
 */

public class Solution00451 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public String frequencySortArray(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            int max = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > count[max]) {
                    max = i;
                }
            }
            if (count[max] > 0) {
                sb.repeat(max, count[max]);
                count[max] = 0;
            }
        }
        return sb.toString();
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public String frequencySortMap(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.merge(c, 1, Integer::sum);
        }

        StringBuilder sb = new StringBuilder();
        count.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> sb.repeat(entry.getKey(), entry.getValue()));

        return sb.toString();
    }

}