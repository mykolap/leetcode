package leetcode;

import java.util.Arrays;

/**
 * 881. Boats to Save People
 * <a href="https://leetcode.com/problems/boats-to-save-people">Web link</a>
 * Medium
 */

public class Solution00881 {

    // Time complexity: O(n log n)
    // Space complexity: O(1)
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }
        return boats;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int numRescueBoatsBucketSort(int[] people, int limit) {
        int[] buckets = new int[limit + 1];
        for (int p : people) {
            buckets[p]++;
        }

        int left = 0;
        int right = limit;
        int boats = 0;

        while (left <= right) {
            while (buckets[left] == 0 && left <= right) {
                left++;
            }
            while (buckets[right] == 0 && left <= right) {
                right--;
            }
            if (left > right) {
                break;
            }
            if (left == right) {
                if (left * 2 > limit) {
                    boats += buckets[left];
                    break;
                } else {
                    boats += buckets[left] / 2 + buckets[left] % 2;
                    break;
                }
            }
            boolean hasPairs = false;
            while (left + right <= limit && buckets[left] > 0 && buckets[right] > 0) {
                int min = Math.min(buckets[left], buckets[right]);
                buckets[left] -= min;
                buckets[right] -= min;
                boats += min;
                hasPairs = true;
            }
            if (!hasPairs) {
                boats += buckets[right]; // if cannot be paired with smallest left, cannot be paired with any other
                buckets[right] = 0;
            }
        }

        return boats;
    }

}