package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * 22. Generate Parentheses
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3 Output: ["((()))","(()())","(())()","()(())","()()()"] Example 2:
 * <p>
 * Input: n = 1 Output: ["()"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 */
public class Solution00022 {

    // Time: O(4^n)
    // Space: O(n)
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", n, n);
        return result;
    }

    private void generateParenthesis(List<String> result, String current, int remainOpen, int remainClose) {
        // there are 4 possible combinations
        // Open parenthesis, valid combination:
        // Open parenthesis, invalid combination:
        // Close parenthesis, valid combination:
        // Close parenthesis, invalid combination:
        if (remainOpen == 0 && remainClose == 0) {
            result.add(current);
            return;
        }
        if (remainOpen > 0) {
            generateParenthesis(result, current + "(", remainOpen - 1, remainClose);
        }
        if (remainClose > 0 && remainClose > remainOpen) {
            generateParenthesis(result, current + ")", remainOpen, remainClose - 1);
        }
    }

    public List<String> generateParenthesisNonRecursive(int n) {
        List<String> res = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        queue.add("");

        while (!queue.isEmpty()) {
            String str = queue.poll();

            if (str.length() == 2 * n) {
                if (isValid(str)) {
                    res.add(str);
                }
                continue;
            }

            queue.add(str + "(");
            queue.add(str + ")");
        }

        return res;
    }

    private boolean isValid(String str) {
        int open = 0;
        int close = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                close++;
            }

            if (close > open) {
                return false;
            }
        }

        return open == close;
    }

}
