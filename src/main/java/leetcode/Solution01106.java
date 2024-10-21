/**
 * 1106. Parsing A Boolean Expression
 * <a href="https://leetcode.com/problems/parsing-a-boolean-expression">Web link</a>
 * Hard
 */

package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution01106 {

    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char currChar : expression.toCharArray()) {
            if (currChar == ',' || currChar == '(') {
                continue;
            }
            if (currChar == 't' ||
                    currChar == 'f' ||
                    currChar == '!' ||
                    currChar == '&' ||
                    currChar == '|') {
                stack.push(currChar);
            } else if (currChar == ')') {
                boolean hasTrue = false;
                boolean hasFalse = false;
                while (stack.peek() != '!' &&
                        stack.peek() != '&' &&
                        stack.peek() != '|') {
                    char topValue = stack.pop();
                    if (topValue == 't') hasTrue = true;
                    if (topValue == 'f') hasFalse = true;
                }
                char op = stack.pop();
                if (op == '!') {
                    stack.push(hasTrue ? 'f' : 't');
                } else if (op == '&') {
                    stack.push(hasFalse ? 'f' : 't');
                } else {
                    stack.push(hasTrue ? 't' : 'f');
                }
            }
        }
        return stack.peek() == 't';
    }

}