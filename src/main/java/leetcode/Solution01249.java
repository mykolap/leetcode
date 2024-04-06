package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * Medium
 */

public class Solution01249 {
    // Time: O(n)
    // Space: O(n)
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int openedParentesis = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openedParentesis++;
            } else if (c == ')' && openedParentesis == 0) {
                continue;
            } else if (c == ')') {
                openedParentesis--;
            }
            sb.append(c);
        }

        StringBuilder finalResult = new StringBuilder();
        int length = sb.length();

        for (int i = length - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && openedParentesis-- > 0) {
                continue;
            }
            finalResult.append(sb.charAt(i));
        }

        return finalResult.reverse().toString();
    }

    public String minRemoveToMakeValidStack(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] arr = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ')') {
                if (stack.isEmpty()) {
                    arr[i] = true;
                } else {
                    arr[stack.pop()] = false;
                }
            } else if (cur == '(') {
                stack.add(i);
            }
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = true;
        }

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if ((cur == '(' || cur == ')') && arr[i]) continue;
            res.append(cur);
        }
        return res.toString();
    }

}