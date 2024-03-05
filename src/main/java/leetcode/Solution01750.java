package leetcode;

/**
 * 1750. Minimum Length of String After Deleting Similar Ends
 * https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
 * Medium
 */

public class Solution01750 {

    // Time: O(n)
    // Space: O(1)
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right &&
               s.charAt(left) == s.charAt(right)) {
            char current = s.charAt(left);
            while (left <= right && s.charAt(left) == current) {
                left++;
            }
            while (left <= right && s.charAt(right) == current) {
                right--;
            }
        }
        return right - left + 1;
    }

}