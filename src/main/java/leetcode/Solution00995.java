package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 995. Minimum Number of K Consecutive Bit Flips
 * <a href="https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips">Web link</a>
 * Hard
 */

public class Solution00995 {

    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int flipCount = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            flipCount += diff[i];
            if ((nums[i] + flipCount) % 2 == 0) {
                if (i + k > n) {
                    return -1;
                }
                result++;
                flipCount++;
                diff[i + k]--;
            }
        }
        return result;
    }

    public int minKBitFlipsQueue(int[] nums, int k) {
        int n = nums.length;
        int numberOfFlips = 0;
        Queue<Integer> flipIndices = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!flipIndices.isEmpty() && flipIndices.peek() < i) {
                flipIndices.poll();
            }
            if (flipIndices.size() % 2 == nums[i]) {
                final int nextFlipIndex = i + k - 1;
                if (nextFlipIndex >= n) {
                    return -1;
                }
                numberOfFlips++;
                flipIndices.add(nextFlipIndex);
            }
        }
        return numberOfFlips;
    }

}