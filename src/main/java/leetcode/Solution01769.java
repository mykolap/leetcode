/**
 * 1769. Minimum Number of Operations to Move All Balls to Each Box
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution01769 {

    public int[] minOperations(String boxes) {
        int strLen = boxes.length();
        int[] result = new int[strLen];
        int ballCount = 0;
        int moveCount = 0;
        for (int i = 0; i < strLen; i++) {
            char ch = boxes.charAt(i);
            result[i] = ballCount + moveCount;
            moveCount += ballCount;
            if (ch == '1') {
                ballCount++;
            }
        }
        ballCount = 0;
        moveCount = 0;
        for (int i = strLen - 1; i >= 0; i--) {
            char ch = boxes.charAt(i);
            result[i] += ballCount + moveCount;
            moveCount += ballCount;
            if (ch == '1') {
                ballCount++;
            }
        }
        return result;
    }

    public int[] minOperationsOnePass(String boxes) {
        int strLen = boxes.length();

        int[] result = new int[strLen];

        int ballCountLeft = 0;
        int moveCountLeft = 0;
        int ballCountRight = 0;
        int moveCountRight = 0;

        for (int i = 0; i < strLen; i++) {
            // left
            char charLeft = boxes.charAt(i);
            result[i] += moveCountLeft;
            if (charLeft == '1') {
                ballCountLeft++;
            }
            moveCountLeft += ballCountLeft;
            // right
            int j = strLen - 1 - i;
            char charRight = boxes.charAt(j);
            result[j] += moveCountRight;
            if (charRight == '1') {
                ballCountRight++;
            }
            moveCountRight += ballCountRight;
        }
        return result;
    }

}