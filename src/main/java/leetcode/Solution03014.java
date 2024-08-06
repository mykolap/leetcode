package leetcode;

/**
 * 3014. Minimum Number of Pushes to Type Word I
 * <a href="https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i">Web link</a>
 * Easy
 */

public class Solution03014 {

    public int minimumPushes(String word) {
        int n = word.length();
        int result = 0;
        while (n > 0) {
            result += n;
            n -= 8;
        }
        return result;
    }

}