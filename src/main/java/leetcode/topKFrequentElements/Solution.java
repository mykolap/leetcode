package leetcode.topKFrequentElements;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 347. Top K Frequent Elements
 * <p>
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * <p>
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 3, 2, 2};
        int k = 2;

        int[] result = new Solution().topKFrequent(nums, k);

        for (int i : result) {
            System.out.println(i);
        }
    }

    // Time: O(n)
    // Space: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        // Create a hash map to store the frequency of each element in the array.
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            int updatedValue = frequencyMap.merge(num, 1, Integer::sum);
            max = Math.max(max, updatedValue);
        }

        // Create a buckets to store the elements in the array, grouped by frequency.
        List<Integer>[] buckets = new List[max + 1];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            final int freqPosition = entry.getValue();
            if (buckets[freqPosition] == null) {
                buckets[freqPosition] = new ArrayList<>();
            }
            buckets[freqPosition].add(entry.getKey());
        }

        // Create an array to store the top k elements.
        int[] result = new int[k];

        int resultPos = 0;
        int i = buckets.length - 1;
        while (i >= 0 && resultPos < k) {
            if (buckets[i] == null) {
                i--;
                continue;
            }
            for (Integer num : buckets[i]) {
                result[resultPos++] = num;
                if (resultPos == k) {
                    break;
                }
            }
            i--;
        }
        return result;
    }

}
