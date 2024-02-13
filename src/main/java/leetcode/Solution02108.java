package leetcode;

/**
 * 2108. Find First Palindromic String in the Array
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array
 * Easy
 */
public class Solution02108 {

    // Time: O(n^2)
    // Space: O(1)
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}