package leetcode;

/**
 * 1915. Number of Wonderful Substrings
 * <a href="https://leetcode.com/problems/number-of-wonderful-substrings">Web link</a> |
 * Medium
 */

public class Solution01915 {

    public long wonderfulSubstrings(String word) {
        long result = 0;
        int n = word.length();
        int[] count = new int[1024];
        count[0] = 1;
        int mask = 0;
        for (int i = 0; i < n; i++) {
            mask ^= 1 << (word.charAt(i) - 'a');
            result += count[mask];
            for (int j = 0; j < 10; j++) {
                result += count[mask ^ (1 << j)];
            }
            count[mask]++;
        }
        return result;
    }

}