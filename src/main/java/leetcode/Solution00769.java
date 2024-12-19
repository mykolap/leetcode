/**
 * 769. Max Chunks To Make Sorted
 * <a href="https://leetcode.com/problems/max-chunks-to-make-sorted">Web link</a>
 * Medium
 */

package leetcode;

public class Solution00769 {

    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i)
                count++;
        }

        return count;
    }

}