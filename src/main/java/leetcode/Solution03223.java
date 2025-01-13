/**
 * 3223. Minimum Length of String After Operations
 * <a href="https://leetcode.com/problems/minimum-length-of-string-after-operations">Web link</a>
 * Medium
 */

package leetcode;

public class Solution03223 {

    public int minimumLength(String s) {
        int n = s.length();
        int removableLen = 0;
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int frequency : freq) {
            if (frequency % 2 != 0) {
                removableLen += frequency - 1;
            } else if (frequency != 0) {
                removableLen += frequency - 2;
            }
        }

        return n - removableLen;
    }

}