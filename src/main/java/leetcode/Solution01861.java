/**
 * 1861. Rotating the Box
 * <a href="https://leetcode.com/problems/rotating-the-box">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution01861 {

    public char[][] rotateTheBox(char[][] box) {
        int totalOldRows = box.length;
        int totalOldColumns = box[0].length;
        char[][] rotated = new char[totalOldColumns][totalOldRows];

        for (int oldRow = 0; oldRow < totalOldRows; oldRow++) {
            int last = totalOldColumns - 1;
            final int newColumn = totalOldRows - 1 - oldRow;
            for (int oldColumn = totalOldColumns - 1; oldColumn >= 0; oldColumn--) {
                int newRow = oldColumn;
                if (box[oldRow][oldColumn] == '#') {
                    if (newRow != last) {
                        rotated[newRow][newColumn] = '.';
                        newRow = last;
                    }
                    rotated[newRow][newColumn] = '#';
                    --last;
                } else if (box[oldRow][oldColumn] == '*') {
                    rotated[newRow][newColumn] = '*';
                    last = newRow - 1;
                } else {
                    rotated[newRow][newColumn] = '.';
                }
            }
        }

        return rotated;
    }

}