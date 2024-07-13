package leetcode;

import java.util.*;

/**
 * 2751. Robot Collisions
 * <a href="https://leetcode.com/problems/robot-collisions">Web link</a> |
 * Hard
 */

public class Solution02751 {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < positions.length; i++) {
            indexMap.put(positions[i], i);
        }
        Arrays.sort(positions);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int position : positions) {
            int index = indexMap.get(position);
            if (directions.charAt(index) == 'R') {
                stack.push(index);
            } else {
                while (!stack.isEmpty() && healths[index] > 0) {
                    int i2 = stack.pop();
                    if (healths[index] > healths[i2]) {
                        healths[i2] = 0;
                        healths[index] -= 1;
                    } else if (healths[index] < healths[i2]) {
                        healths[index] = 0;
                        healths[i2] -= 1;
                        stack.push(i2);
                    } else {
                        healths[index] = 0;
                        healths[i2] = 0;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int health : healths) {
            if (health > 0) {
                result.add(health);
            }
        }
        return result;
    }

}