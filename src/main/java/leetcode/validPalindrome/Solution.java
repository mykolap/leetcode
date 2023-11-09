package leetcode.validPalindrome;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * 125. Valid Palindrome
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 * <p>
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 * <p>
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class Solution {

    // Time: O(n)
    // Space: O(1)
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);

            if (!Character.isLetterOrDigit(startChar)) {
                start++;
            } else if (!Character.isLetterOrDigit(endChar)) {
                end--;
            } else {
                if (Character.toLowerCase(startChar) != Character.toLowerCase(endChar)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

}
