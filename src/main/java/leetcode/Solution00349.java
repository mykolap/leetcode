package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * <a href="https://leetcode.com/problems/intersection-of-two-arrays">Web link</a>
 * Easy
 */

public class Solution00349 {

    // Time: O(n + m)
    // Space: O(n + m)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            set2.add(n);
        }
        set1.retainAll(set2);
        return set1.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // Time: O(n + m)
    // Space: O(n + m)
    public int[] intersectionImproved(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(nums1.length);
        for (int n : nums1) {
            set1.add(n);
        }
        List<Integer> result = new ArrayList<>(set1.size());
        for (int n : nums2) {
            if (set1.contains(n)) {
                result.add(n);
                set1.remove(n);
            }
        }
        int[] arr = new int[result.size()];
        for (int index = 0; index < result.size(); index++) {
            arr[index] = result.get(index);
        }
        return arr;
    }
}