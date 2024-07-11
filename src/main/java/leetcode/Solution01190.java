package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1190. Reverse Substrings Between Each Pair of Parentheses
 * <a href="https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/">Web link</a>
 * Medium
 */

public class Solution01190 {

    public String reverseParentheses(String s) {
        int n = s.length();
        State state = new State(0, n - 1);
        return reverseParentheses(s, state).toString();
    }

    StringBuilder reverseParentheses(String s, State state) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = state.start;
        while (i <= state.end) {
            char c = s.charAt(i);
            if (c == '(') {
                state.start = i;
                State newState = new State(i + 1, state.end);
                StringBuilder stringBuilderBody = reverseParentheses(s, newState);
                stringBuilder.append(stringBuilderBody.reverse());
                i = newState.end + 1;
            } else if (c == ')') {
                state.end = i;
                return stringBuilder;
            } else {
                stringBuilder.append(c);
                ++i;
            }
        }
        return stringBuilder;
    }

    static class State {
        int start;
        int end;

        State(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public String reverseParenthesesStackBased(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] result = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (result[i] == '(') {
                stack.push(i);
            } else if (result[i] == ')') {
                reverse(result, stack.pop() + 1, i - 1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : result) {
            if (c != '(' && c != ')') {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    private void reverse(char[] result, int start, int end) {
        while (start < end) {
            char temp = result[start];
            result[start] = result[end];
            result[end] = temp;
            start++;
            end--;
        }
    }

}