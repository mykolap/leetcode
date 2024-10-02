/**
 * 1331. Rank Transform of an Array
 * <a href="https://leetcode.com/problems/rank-transform-of-an-array">Web link</a>
 * Easy
 */

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution01331 {

    public int[] arrayRankTransform(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        int index = 1;
        int prev = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arrCopy) {
            if (j == prev)
                continue;
            map.put(j, index++);
            prev = j;
        }
        for (int i = 0; i < arr.length; i++) { // n
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

}