package leetcode;

import java.util.*;

/**
 * 752. Open the Lock
 * https://leetcode.com/problems/open-the-lock/
 * Medium
 */

public class Solution00752 {

    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        Collections.addAll(deadSet, deadends);
        if (deadSet.contains("0000")) {
            return -1;
        }
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        visited.add("0000");
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (String next : getNextStates(current)) {
                    if (next.equals(target)) {
                        return steps;
                    }
                    if (!visited.contains(next) && !deadSet.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getNextStates(String current) {
        List<String> nextStates = new ArrayList<>();
        char[] chars = current.toCharArray();
        for (int i = 0; i < 4; i++) {
            char original = chars[i];
            chars[i] = (char) ((chars[i] - '0' + 1) % 10 + '0');
            nextStates.add(new String(chars));
            chars[i] = (char) ((original - '0' + 9) % 10 + '0');
            nextStates.add(new String(chars));
            chars[i] = original;
        }
        return nextStates;
    }

}