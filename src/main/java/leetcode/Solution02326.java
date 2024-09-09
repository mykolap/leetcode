package leetcode;

import leetcode.common.ListNode;

import java.util.Arrays;

/**
 * 2326. Spiral Matrix IV
 * <a href="https://leetcode.com/problems/spiral-matrix-iv">Web link</a> |
 * Medium
 */

public class Solution02326 {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], -1);
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] pos = new int[]{0, 0};
        int dirIndex = 0;
        while (head != null) {
            result[pos[0]][pos[1]] = head.val;
            head = head.next;
            int nextRow = pos[0] + directions[dirIndex][0];
            int nextCol = pos[1] + directions[dirIndex][1];
            if (nextRow < 0 || nextRow >= m ||
                nextCol < 0 || nextCol >= n ||
                result[nextRow][nextCol] != -1) {
                dirIndex = (dirIndex + 1) % 4;
                int[] newDirection = directions[dirIndex];
                nextRow = pos[0] + newDirection[0];
                nextCol = pos[1] + newDirection[1];
            }
            pos[0] = nextRow;
            pos[1] = nextCol;
        }
        return result;
    }

}