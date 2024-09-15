package leetcode;

import java.util.Arrays;

/**
 * 1371. Find the Longest Substring Containing Vowels in Even Counts
 * <a href="https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts">Web link</a>
 * Medium
 */

public class Solution01371 {

    public int findTheLongestSubstring(String s) {
        int length = s.length();
        int[] vowelCounts = new int[5]; // a, e, i, o, u
        int[] firstOccurrence = new int[32];
        Arrays.fill(firstOccurrence, -1);
        firstOccurrence[0] = 0;
        int result = 0;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                vowelCounts[0]++;
            } else if (c == 'e') {
                vowelCounts[1]++;
            } else if (c == 'i') {
                vowelCounts[2]++;
            } else if (c == 'o') {
                vowelCounts[3]++;
            } else if (c == 'u') {
                vowelCounts[4]++;
            }

            int state = 0;
            for (int j = 0; j < 5; j++) {
                if (vowelCounts[j] % 2 != 0) {
                    state |= (1 << j);
                }
            }

            if (firstOccurrence[state] == -1) {
                firstOccurrence[state] = i + 1;
            } else {
                result = Math.max(result, i - firstOccurrence[state] + 1);
            }
        }

        return result;
    }

}