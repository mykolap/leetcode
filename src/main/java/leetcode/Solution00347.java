package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
public class Solution00347 {

    // Time: O(n log n)
    // Space: O(n)
    public int[] topKFrequentStream(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // Time: O(n log n)
    // Space: O(n)
    public int[] topKFrequentInSteps(int[] nums, int k) {
        // Create a map to keep track of the frequency of each number.
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }

        return frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Sort the map by value in descending order
                .limit(k)  // limit the results to k.
                .mapToInt(entry -> entry.getKey()) // convert to int
                .toArray(); // convert to array
    }

}
