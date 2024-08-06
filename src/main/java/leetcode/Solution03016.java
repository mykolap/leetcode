package leetcode;

import java.util.Arrays;

/**
 * 3016. Minimum Number of Pushes to Type Word II
 * <a href="https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii">Web link</a>
 * Medium
 */

public class Solution03016 {

    public int minimumPushes(String word) {
        int n = word.length();
        if (n < 8) {
            return n;
        }
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[word.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);
        int currentCount = 0;
        int distinctLetterCount = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            int numberOfPresses = 1 + distinctLetterCount / 8;
            currentCount += (freq[i] * numberOfPresses);
            distinctLetterCount++;
        }
        return currentCount;
    }

}