package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1636. Sort Array by Increasing Frequency
 * <a href="https://leetcode.com/problems/sort-array-by-increasing-frequency">Web link</a> |
 * Easy
 */

public class Solution01636 {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new TreeMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        TreeMap<Integer, List<Map.Entry<Integer, Integer>>> treeMap = frequencyMap.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        TreeMap::new,
                        Collectors.toList()));
        List<Integer> result = new ArrayList<>();
        for (var entry : treeMap.entrySet()) {
            List<Map.Entry<Integer, Integer>> entries = entry.getValue();
            if (entries.size() > 1) {
                entries.stream()
                        .sorted((e1, e2) -> e2.getKey() - e1.getKey())
                        .forEach(entry2 -> {
                            for (int i = 0; i < entry2.getValue(); i++) {
                                result.add(entry2.getKey());
                            }
                        });
            } else {
                final Map.Entry<Integer, Integer> first = entries.getFirst();
                for (int i = 0; i < first.getValue(); i++) {
                    result.add(first.getKey());
                }
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    public int[] frequencySortOptimized(int[] nums) {
        Map<Integer, Integer> frequencyMap = new TreeMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> {
                    int freqA = frequencyMap.get(a);
                    int freqB = frequencyMap.get(b);
                    if (freqA != freqB) {
                        return freqA - freqB;
                    }
                    return b - a;
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] frequencySortOptimized2(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
        entries.sort((e1, e2) -> {
            int freqCompare = Integer.compare(e1.getValue(), e2.getValue());
            return freqCompare != 0 ? freqCompare : Integer.compare(e2.getKey(), e1.getKey());
        });
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

}