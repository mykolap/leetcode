package leetcode.validParentheses;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 20. Valid Parentheses
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()" Output: true Example 2:
 * <p>
 * Input: s = "()[]{}" Output: true Example 3:
 * <p>
 * Input: s = "(]" Output: false Example 4:
 * <p>
 * Input: s = "([)]" Output: false Example 5:
 * <p>
 * Input: s = "{[]}" Output: true
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104 s consists of parentheses only '()[]{}'.
 */
public class Solution {

    // Time: O(n)
    // Space: O(n)
    public boolean isValid(String s) {
        // Check for empty string.
        if (s.isEmpty()) {
            return true;
        }

        // Check for odd length.
        if (s.length() % 2 != 0) {
            return false;
        }

        // Create a stack.
        Deque<Character> stack = new LinkedList<>();

        // Iterate over the string.
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // If the character is an opening bracket, push it to the stack.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If the stack is empty, return false.
                if (stack.isEmpty()) {
                    return false;
                }

                // If the character is a closing bracket, pop the stack and compare.
                char top = stack.pop();

                if (c == ')' && top != '(') {
                    return false;
                }

                if (c == '}' && top != '{') {
                    return false;
                }

                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }

        // If the stack is not empty, return false.
        return stack.isEmpty();
    }

}
