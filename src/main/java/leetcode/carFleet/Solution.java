package leetcode.carFleet;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/car-fleet/
 * 853. Car Fleet
 * <p>
 * N cars are going to the same destination along a one lane road.  The destination is target miles away.
 * <p>
 * Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.
 * <p>
 * A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
 * <p>
 * The distance between these two cars is ignored - they are assumed to have the same position.
 * <p>
 * A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.
 * <p>
 * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
 * <p>
 * <p>
 * <p>
 * How many car fleets will arrive at the destination?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3] Output: 3 Explanation: The cars starting at 10 and 8 become a fleet, meeting each other at 12.
 * The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself. The cars starting at 5 and 3 become a fleet, meeting each other at 6.
 * Note that no other cars meet these fleets before the destination, so the answer is 3. Example 2:
 * <p>
 * Input: target = 10, position = [3], speed = [3] Output: 1
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= N <= 10 ^ 4 0 < target <= 10 ^ 6 0 < speed[i] <= 10 ^ 6 0 <= position[i] < target All initial positions are different.
 */
public class Solution {

    @Test
    void testCarFleet() {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        assertEquals(3, carFleet(target, position, speed));

        target = 10;
        position = new int[]{3};
        speed = new int[]{3};

        assertEquals(1, carFleet(target, position, speed));

        target = 100;
        position = new int[]{0, 2, 4};
        speed = new int[]{4, 2, 1};

        assertEquals(1, carFleet(target, position, speed));
    }

    // Time: O(nlogn)
    // Space: O(n)
    public int carFleet(int target, int[] position, int[] speed) {
        // Create a map to keep track of the position and speed.
        Map<Integer, Integer> map = new HashMap<>();

        // Loop through the position array.
        for (int i = 0; i < position.length; i++) {
            // Put the position and speed in the map.
            map.put(position[i], speed[i]);
        }

        // Sort the position array.
        Arrays.sort(position);

        // Create a variable to keep track of the number of fleets.
        int fleet = 0;

        // Create a variable to keep track of the time.
        double time = 0;

        // Loop through the position array.
        for (int i = position.length - 1; i >= 0; i--) {
            // Calculate the time.
            final int currentSpeed = map.get(position[i]);
            double currentTime = (double) (target - position[i]) / currentSpeed;

            // If the current time is greater than the time.
            if (currentTime > time) {
                // Update the time.
                time = currentTime;

                // Increment the result.
                fleet++;
            }
        }

        return fleet;
    }

}
