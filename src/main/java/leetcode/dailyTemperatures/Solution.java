package leetcode.dailyTemperatures;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * 739. Daily Temperatures
 * <p>
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * <p>
 * Example 1:
 * <p>
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 * <p>
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 * <p>
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
public class Solution {

    @Test
    public void testDailyTemperatures() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(expected, dailyTemperaturesBruteforce(temperatures));
        assertArrayEquals(expected, dailyTemperatures(temperatures));

        int[] temperatures2 = {30, 40, 50, 60};
        int[] expected2 = {1, 1, 1, 0};
        assertArrayEquals(expected2, dailyTemperaturesBruteforce(temperatures2));
        assertArrayEquals(expected2, dailyTemperatures(temperatures2));

        int[] temperatures3 = {30, 60, 90};
        int[] expected3 = {1, 1, 0};
        assertArrayEquals(expected3, dailyTemperaturesBruteforce(temperatures3));
        assertArrayEquals(expected3, dailyTemperatures(temperatures3));

        int[] temperatures4 = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] expected4 = {8, 1, 5, 4, 3, 2, 1, 1, 0, 0};
        assertArrayEquals(expected4, dailyTemperaturesBruteforce(temperatures4));
        assertArrayEquals(expected4, dailyTemperatures(temperatures4));
    }

    // Time: O(n^2)
    // Space: O(n)
    public int[] dailyTemperaturesBruteforce(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    // Time: O(n)
    // Space: O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        final int size = temperatures.length;
        int[] result = new int[size];
        // stack to store the index of the temperatures
        Deque<Integer> stack = new LinkedList<>();
        // push the first index onto the stack
        stack.push(0);

        // Iterate over the temperatures, starting from the second one.
        for (int i = 1; i < size; i++) {
            // While the stack is not empty and the current temperature is greater than the temperature at the top of the stack.
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }

            // Push the current temperature onto the stack
            stack.push(i);
        }
        return result;
    }

}
