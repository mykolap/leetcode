package leetcode;

import java.util.Arrays;

/**
 * 1051. Height Checker
 * https://leetcode.com/problems/height-checker/
 * Easy
 */

public class Solution01051 {

    public int heightChecker(int[] heights) {
        final int n = heights.length;
        int[] heightsCopy = Arrays.copyOf(heights, n);
        Arrays.sort(heightsCopy);
        int mismatch = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != heightsCopy[i]) {
                mismatch++;
            }
        }
        return mismatch;
    }

    public int heightCheckerCountingSort(int[] heights) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int height : heights) {
            min = Math.min(min, height);
            max = Math.max(max, height);
        }
        int[] countArr = new int[max - min + 1];
        for (int height : heights) {
            countArr[height - min]++;
        }
        int pos = 0;
        int mismatch = 0;
        for (int i = 0; i < countArr.length; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                int expectedValueAtPosition = i + min;
                if (heights[pos] != expectedValueAtPosition) {
                    mismatch++;
                }
                pos++;
            }
        }
        return mismatch;
    }

}