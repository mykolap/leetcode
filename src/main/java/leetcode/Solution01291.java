package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sequential-digits
 * 1291. Sequential Digits
 * Medium
 * <p>
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 * <p>
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 * <p>
 * Example 1:
 * <p>
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 * <p>
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 * <p>
 * Constraints:
 * <p>
 * 10 <= low <= high <= 10^9
 */
public class Solution01291 {

    // Time complexity: O(1)
    // Space complexity: O(1)
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        int minDigits = getNumberOfDigits(low);
        int maxDigits = getNumberOfDigits(high);

        for (int length = minDigits; length <= maxDigits; length++) {
            for (int start = 1; start <= 9 - length + 1; start++) {
                int num = 0;
                for (int i = 0; i < length; i++) {
                    num = num * 10 + (start + i);
                }
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }

        return result;
    }

    private int getNumberOfDigits(int number) {
        return (int) (Math.log10(number) + 1);
    }

    // Time complexity: O(1)
    // Space complexity: O(1)
    public List<Integer> sequentialDigitsWithSorting(int low, int high) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            int num = i;
            for (int j = i + 1; j <= 9; j++) {
                num = num * 10 + j;
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        result.sort(null);

        return result;
    }

}