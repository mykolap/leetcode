package leetcode;

/**
 * 2022. Convert 1D Array Into 2D Array
 * <a href="https://leetcode.com/problems/convert-1d-array-into-2d-array">Web link</a> |
 * Easy
 */

public class Solution02022 {

    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if (m * n != len) return new int[][]{};
        int[][] result = new int[m][n];
        for (int i = 0; i < len; i++) {
            result[i / n][i % n] = original[i];
        }
        return result;
    }

}