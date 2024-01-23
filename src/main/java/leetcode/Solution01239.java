package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1239. Maximum Length of a Concatenated String with Unique Characters
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
 * <p>
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 * <p>
 * Return the maximum possible length of s.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 * <p>
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 * <p>
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */
public class Solution01239 {

    // Time complexity: O(n * 2^n)
    // Space complexity: O(n)
    public int maxLength(List<String> arr) {
        ResultWrapper resultWrapper = new ResultWrapper();
        backtrace(arr, 0, new HashSet<>(), resultWrapper);
        return resultWrapper.maxLen;
    }

    private void backtrace(List<String> arr, int index, Set<Character> set, ResultWrapper resultWrapper) {
        if (index == arr.size()) {
            return;
        }

        String s = arr.get(index);
        Set<Character> newSet = getSet(s, set);
        if (newSet == null) {
            // If the current string contains duplicate characters or characters already in the set,
            // skip it and move on to the next string.
            backtrace(arr, index + 1, set, resultWrapper);
        } else {
            // If the current string contains unique characters, add them to the set and update the maximum length.
            set.addAll(newSet);
            resultWrapper.maxLen = Math.max(resultWrapper.maxLen, set.size());
            backtrace(arr, index + 1, set, resultWrapper);

            // After exploring the current string, remove its characters from the set and explore the remaining strings.
            set.removeAll(newSet);
            backtrace(arr, index + 1, set, resultWrapper);
        }
    }

    private Set<Character> getSet(String s, Set<Character> set) {
        Set<Character> newSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c) || newSet.contains(c)) {
                return null;
            }
            newSet.add(c);
        }
        return newSet;
    }

    static class ResultWrapper {
        int maxLen = 0;
    }
}