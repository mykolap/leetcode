package leetcode;

/**
 * 1404. Number of Steps to Reduce a Number in Binary Representation to One
 * <a href="https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one">Web link</a> |
 * Medium
 */

public class Solution01404 {

    public int numSteps(String s) {
        int steps = 0;
        char[] binary = s.toCharArray();
        int n = binary.length;
        int carry = 0;

        for (int i = n - 1; i > 0; i--) {
            if (binary[i] - '0' + carry == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps++;
            }
        }

        return steps + carry;
    }

}