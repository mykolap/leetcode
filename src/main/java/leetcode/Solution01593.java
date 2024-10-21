/**
 * 1593. Split a String Into the Max Number of Unique Substrings
 * <a href="https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution01593 {

    public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();
        int[] maxCount = {0};
        backtrack(s, 0, seen, 0, maxCount);
        return maxCount[0];
    }

    private void backtrack(String s, int start, Set<String> seen,
                           int count, int[] maxCount) {
        if (count + (s.length() - start) <= maxCount[0]) {
            return;
        }

        if (start == s.length()) {
            maxCount[0] = Math.max(maxCount[0], count);
            return;
        }

        for (int end = start + 1; end <= s.length(); ++end) {
            String substring = s.substring(start, end);

            if (!seen.contains(substring)) {
                seen.add(substring);

                backtrack(s, end, seen, count + 1, maxCount);

                seen.remove(substring);
            }
        }
    }

}