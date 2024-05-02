package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 2441. Largest Positive Integer That Exists With Its Negative
 * https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
 * Medium
 */

public class Solution02441 {

    public int findMaxKFirstApproach(int[] nums) {
        TreeSet<Integer> positiveSet = new TreeSet<>();
        TreeSet<Integer> negativeSet = new TreeSet<>();
        for (int num : nums) {
            if (num > 0) {
                positiveSet.add(num);
            } else {
                negativeSet.add(-num);
            }
        }
        if (positiveSet.isEmpty() || negativeSet.isEmpty()) {
            return -1;
        }
        Iterator<Integer> positiveIterator = positiveSet.descendingIterator();
        Iterator<Integer> negativeIterator = negativeSet.descendingIterator();
        int currentNegativeValue = negativeIterator.next();
        while (positiveIterator.hasNext()) {
            int currentPositiveValue = positiveIterator.next();
            while (currentNegativeValue > currentPositiveValue && negativeIterator.hasNext()) {
                currentNegativeValue = negativeIterator.next();
            }
            if (currentNegativeValue == currentPositiveValue) {
                return currentPositiveValue;
            }
        }
        return -1;
    }

    public int findMaxK(int[] nums) {
        Set<Integer> negativeSet = new HashSet<>();
        int max = -1;
        for (int num : nums) {
            if (num < 0) {
                negativeSet.add(num);
            }
        }
        for (int num : nums) {
            if (num > 0 && negativeSet.contains(-num)) {
                max = Math.max(max, num);
            }
        }
        return max;
    }

}