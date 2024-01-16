package leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * 380. Insert Delete GetRandom O(1)
 * Medium
 * <p>
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom(): Returns a random element from current set of elements.
 * Each element must have the same probability of being returned.
 * <p>
 * Example:
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class Solution00380 {

    public static class RandomizedSet {

        private final List<Integer> list;
        private final Map<Integer, Integer> map;
        private final Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            // Check if the value exists in the map
            if (!map.containsKey(val)) {
                // If it doesn't exist, return false
                return false;
            }

            // Get the index of the value in the list
            int index = map.get(val);

            // Get the last element in the list
            int lastElement = list.get(list.size() - 1);

            // Replace the element at the index with the last element
            list.set(index, lastElement);

            // Update the map to reflect the new position of the last element
            map.put(lastElement, index);

            // Remove the last element from the list
            list.remove(list.size() - 1);

            // Remove the value from the map
            map.remove(val);

            // If we've reached this point, the removal was successful, so return true
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }

    }

}
