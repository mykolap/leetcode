package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 2053. Kth Distinct String in an Array
 * <a href="https://leetcode.com/problems/kth-distinct-string-in-an-array">Web link</a> |
 * Medium
 */

public class Solution02053 {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> sequencedMap = new LinkedHashMap<>();
        for (String s : arr) {
            sequencedMap.put(s, sequencedMap.getOrDefault(s, 0) + 1);
        }
        return sequencedMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .skip(k - 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse("");
    }

}