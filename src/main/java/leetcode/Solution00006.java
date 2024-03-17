package leetcode;

/**
 * 6. ZigZag Conversion
 * https://leetcode.com/problems/zigzag-conversion/
 * Medium
 */

public class Solution00006 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        int direction = 1;
        for (char c : s.toCharArray()) {
            rows[row].append(c);
            if (row == 0) {
                direction = 1;
            } else if (row == numRows - 1) {
                direction = -1;
            }
            row += direction;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder r : rows) {
            result.append(r);
        }

        return result.toString();
    }

    public String convertArr(String s, int numRows) {
        int len = s.length();

        if (numRows > len || numRows <= 1) {
            return s;
        }

        int index = 0;
        int diff = 2 * numRows - 2;
        char[] arr = new char[len];

        for (int row = 0; row < numRows; row++) {
            int diagDiff = diff - 2 * row;

            for (int col = row; col < len; col += diff) {
                arr[index] = s.charAt(col);
                index++;

                if (diagDiff > 0 && diagDiff < diff && col + diagDiff < len) {
                    arr[index] = s.charAt(col + diagDiff);
                    index++;
                }
            }
        }

        return new String(arr);
    }

}