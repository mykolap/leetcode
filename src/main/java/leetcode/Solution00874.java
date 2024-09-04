package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 874. Walking Robot Simulation
 * <a href="https://leetcode.com/problems/walking-robot-simulation">Web link</a>
 * Medium
 */

public class Solution00874 {

    private static final int TURN_LEFT = -1;
    private static final int TURN_RIGHT = -2;

    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] curPos = {0, 0};
        int ans = 0;
        int curDir = 0;
        Map<Integer, Set<Integer>> obs = new HashMap<>();
        for (int[] obstacle : obstacles) {
            Set<Integer> setY = obs.computeIfAbsent(obstacle[0], k -> new HashSet<>());
            setY.add(obstacle[1]);
        }

        for (int command : commands) {
            switch (command) {
                case TURN_LEFT -> curDir = (curDir + 1) % 4;
                case TURN_RIGHT -> curDir = (curDir - 1 + 4) % 4;
                default -> {
                    int[] dir = directions[curDir];
                    for (int i = 0; i < command; i++) {
                        int nextX = curPos[0] + dir[0];
                        int nextY = curPos[1] + dir[1];
                        final Set<Integer> hasObstaclesX = obs.get(nextX);
                        if (hasObstaclesX != null && hasObstaclesX.contains(nextY)) {
                            break;
                        }
                        curPos[0] = nextX;
                        curPos[1] = nextY;
                    }
                    ans = Math.max(ans, curPos[0] * curPos[0] + curPos[1] * curPos[1]);
                }
            }
        }
        return ans;
    }

}