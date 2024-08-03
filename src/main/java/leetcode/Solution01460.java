package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1460. Make Two Arrays Equal by Reversing Subarrays
 * <a href="https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays">Web link</a>
 * Easy
 */

public class Solution01460 {

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> freqMapArr = new HashMap<>();
        for (int num : arr) {
            freqMapArr.put(num, freqMapArr.getOrDefault(num, 0) + 1);
        }
        for (int num : target) {
            int freq = freqMapArr.getOrDefault(num, 0);
            if (freq == 0) {
                return false;
            } else {
                freqMapArr.put(num, freq - 1);
            }
        }
        return freqMapArr.values()
                .stream()
                .noneMatch(freq -> freq != 0);
    }

}