package leetcode;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

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
 * How many car fleets will arrive at the destination?
 * <p>
 * Example 1:
 * <p>
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3] Output: 3 Explanation: The cars starting at 10 and 8 become a fleet, meeting each other at 12.
 * The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself. The cars starting at 5 and 3 become a fleet, meeting each other at 6.
 * Note that no other cars meet these fleets before the destination, so the answer is 3. Example 2:
 * <p>
 * Input: target = 10, position = [3], speed = [3] Output: 1
 * <p>
 * Note:
 * <p>
 * 0 <= N <= 10 ^ 4 0 < target <= 10 ^ 6 0 < speed[i] <= 10 ^ 6 0 <= position[i] < target All initial positions are different.
 */
public class Solution00853 {

    // Time: O(nlogn)
    // Space: O(n)
    public int carFleet(int target, int[] position, int[] speed) {
        // Create a map to keep track of the position and speed.
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        // Loop through the position array.
        for (int i = 0; i < position.length; i++) {
            // Put the position and speed in the map.
            map.put(position[i], speed[i]);
        }

        // Create a variable to keep track of the number of fleets.
        int fleet = 0;

        // Create a variable to keep track of the time.
        double time = 0;

        // Loop through the position array.
        for (var entry : map.entrySet()) {
            // Calculate the time.
            final int currentSpeed = entry.getValue();
            double currentTime = (double) (target - entry.getKey()) / currentSpeed;

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
