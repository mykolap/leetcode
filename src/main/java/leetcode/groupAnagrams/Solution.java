package leetcode.groupAnagrams;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * https://leetcode.com/problems/group-anagrams/
 * 49. Group Anagrams
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["eat","tea","tan","ate","nat","bat"] Output: [["bat"],["nat","tan"],["ate","eat","tea"]] Example 2:
 * <p>
 * Input: strs = [""] Output: [[""]] Example 3:
 * <p>
 * Input: strs = ["a"] Output: [["a"]]
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 104 0 <= strs[i].length <= 100 strs[i] consists of lower-case English letters.
 */
public class Solution {

    @Test
    void testGroupAnagrams() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        final List<List<String>> expectedResult = List.of(
                List.of("bat"),
                List.of("tan", "nat"),
                List.of("eat", "tea", "ate")
        );

        final List<List<String>> result1Sorted = groupAnagrams(strs)
                .stream()
                .sorted(Comparator.comparing(List::size))
                .toList();
        assertIterableEquals(expectedResult, result1Sorted);

        final List<List<String>> result2Sorted = groupAnagramsCounting(strs)
                .stream()
                .sorted(Comparator.comparing(List::size))
                .toList();
        assertIterableEquals(expectedResult, result2Sorted);
    }

    // Time: O(n * k log k)
    // Space: O(n * k)
    // runtime Beats 98.84%of users with Java
    // memory Beats 88.47%of users with Java
    public List<List<String>> groupAnagrams(String[] strs) {
        // Check for empty array.
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        // Create a map of sorted string to list of strings.
        Map<String, List<String>> map = new HashMap<>();

        // Iterate over the array.
        for (String str : strs) {
            // Convert the string to char array.
            char[] chars = str.toCharArray();

            // Sort the char array.
            Arrays.sort(chars);

            // Convert the char array to string.
            String key = String.valueOf(chars);

            // Add the string to the map.
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        // Return the map values.
        return new ArrayList<>(map.values());
    }

    // Time: O(n * k)
    // Space: O(n * k)
    // runtime Beats 16.11%of users with Java
    // memory Beats 19.19%of users with Java
    public List<List<String>> groupAnagramsCounting(String[] strs) {
        // Check for empty array.
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        // Create a map of sorted string to list of strings.
        Map<String, List<String>> map = new HashMap<>();

        // Iterate over the array.
        for (String str : strs) {
            // Create an array of 26 characters.
            int[] count = new int[26];

            // Iterate over the string.
            for (char c : str.toCharArray()) {
                // Increment the count of the character.
                count[c - 'a']++;
            }

            // Add the string to the map.
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        // Return the map values.
        return new ArrayList<>(map.values());
    }

}
