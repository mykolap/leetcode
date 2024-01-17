package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/
 * 1207. Unique Number of Occurrences
 * Easy
 * <p>
 * Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.
 * Example 1:
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * <p>
 * Example 2:
 * Input: arr = [1,2]
 * Output: false
 * <p>
 * Example 3:
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 * <p>
 * Constraints:
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class Solution01207 {

    // O(n) time,
    // O(n) space
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int num : arr) {
            freqCount.merge(num, 1, Integer::sum);
        }
        Set<Integer> uniq = new HashSet<>(freqCount.size());
        for (Integer freq : freqCount.values()) {
            if (uniq.contains(freq)) {
                return false;
            }
            uniq.add(freq);
        }
        return true;
    }

}
