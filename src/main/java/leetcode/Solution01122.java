package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1122. Relative Sort Array
 * <a href="https://leetcode.com/problems/relative-sort-array">Web link</a>
 * Easy
 */

public class Solution01122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int pos = 0;
        int[] result = new int[arr1.length];
        for (int num : arr2) {
            int count = countMap.getOrDefault(num, 0);
            for (int i = 0; i < count; i++) {
                result[pos++] = num;
            }
            countMap.remove(num);
        }
        var sorted = countMap.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .toList();
        for (Map.Entry<Integer, Integer> entry : sorted) {
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                result[pos++] = entry.getKey();
            }
        }
        return result;
    }

}