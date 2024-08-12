package leetcode;

/**
 * 66. Plus One
 * <a href="https://leetcode.com/problems/plus-one">Web link</a>
 * Easy
 */

public class Solution00066 {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] newArr = new int[n + 1];
        newArr[0] = 1;
        System.arraycopy(digits, 0, newArr, 1, n);
        return newArr;
    }

}