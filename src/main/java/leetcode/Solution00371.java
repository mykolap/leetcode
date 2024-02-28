package leetcode;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * 371. Sum of Two Integers
 *
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = 2, b = 3
 * Output: 5
 *
 *
 * Constraints:
 *
 * -1000 <= a, b <= 1000
 */
public class Solution00371 {

    // Time: O(1)
    // Space: O(1)
    public int getSum(int a, int b) {
        int carry;
        while (b != 0) {
            // carry now contains common set bits of a and b, shifted left by 1
            carry = (a & b) << 1;

            // Sum of bits of a and b where at least one of the bits is not set
            a = a ^ b;

            b = carry;
        }

        return a;
    }

}
