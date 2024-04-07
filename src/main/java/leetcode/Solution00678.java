package leetcode;

/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 * 678. Valid Parenthesis String
 * Medium
 */

public class Solution00678 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public boolean checkValidString(String s) {
        // Initialize the minimum and maximum number of open brackets
        int maxOpen = 0;
        int minOpen = 0;

        // Iterate over the characters in the string
        for (char c : s.toCharArray()) {
            // Update the minimum and maximum number of open brackets based on the current character
            if (c == '(') {
                maxOpen++;
                minOpen++;
            } else if (c == ')') {
                maxOpen--;
                minOpen--;
            } else {
                maxOpen++;
                minOpen--;
            }

            // If the maximum number of open brackets becomes negative, return 'false'
            if (maxOpen < 0) {
                return false;
            }
            // If the minimum number of open brackets becomes negative, reset it to 0
            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        // If the minimum number of open brackets is 0, return 'true'; otherwise, return 'false'
        return minOpen == 0;
    }

}