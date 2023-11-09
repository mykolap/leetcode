package leetcode.evaluateReversePolishNotation;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 150. Evaluate Reverse Polish Notation
 * <p>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * <p>
 * Note that division between two integers should truncate toward zero.
 * <p>
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to
 * a result, and there will not be any division by zero operation.
 * <p>
 * Example 1:
 * <p>
 * Input: tokens = ["2","1","+","3","*"] Output: 9 Explanation: ((2 + 1) * 3) = 9 Example 2:
 * <p>
 * Input: tokens = ["4","13","5","/","+"] Output: 6 Explanation: (4 + (13 / 5)) = 6 Example 3:
 * <p>
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"] Output: 22 Explanation: ((10 * (6 / ((9 +
 * 3) * -11))) + 17) + 5 = ((10 * (6 / (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 =
 * (0 + 17) + 5 = 17 + 5 = 22
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= tokens.length <= 104 tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200,
 * 200].
 * <p>
 * <p>
 * <p>
 * Follow up: Could you solve it without using stack?
 */
public class Solution {

    // Time: O(n)
    // Space: O(n)
    public int evalRPN(String[] tokens) {
        // Create a stack.
        Deque<Integer> stack = new LinkedList<>();
        int num1;
        int num2;

        // Loop through the tokens.
        for (String token : tokens) {
            // If the token is an operator.
            final char firstChar = token.charAt(0);
            if (Character.isDigit(firstChar) || token.length() > 1) {
                stack.push(Integer.parseInt(token));
            } else {
                num2 = stack.pop();
                num1 = stack.pop();
                switch (firstChar) {
                    case '+' -> stack.push(num1 + num2);
                    case '-' -> stack.push(num1 - num2);
                    case '*' -> stack.push(num1 * num2);
                    case '/' -> stack.push(num1 / num2);
                }
            }
        }

        // Return the top element from the stack.
        return stack.pop();
    }

    // Time: O(n)
    // Space: O(n)
    // Non stack - but works only for simplest cases.
    public int evalRPN2(String[] tokens) {
        int num1 = 0;
        int num2 = 0;
        // Loop through the tokens.
        for (int i = 0, tokensLength = tokens.length; i < tokensLength; i++) {
            if (i == 0) {
                num1 = Integer.parseInt(tokens[i]);
                continue;
            }
            String token = tokens[i];
            // If the token is an operator.
            final char firstChar = token.charAt(0);
            if (Character.isDigit(firstChar)) {
                num2 = Integer.parseInt(token);
            } else {
                num1 = performOperation(firstChar, num1, num2);
                num2 = 0;
            }
        }
        return num1;
    }

    private static int performOperation(char firstChar, int num1, int num2) {
        return switch (firstChar) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
    }

}
