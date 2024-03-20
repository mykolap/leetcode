package leetcode;

/**
 * 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/
 * Medium
 */

public class Solution00621 {

    // time complexity: O(n),
    // space complexity: O(1)
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        int[] taskCounts = new int[26];
        int maxTaskCount = 0;
        int maxTaskCountFrequency = 0;

        for (char task : tasks) {
            int taskIndex = task - 'A';
            taskCounts[taskIndex]++;

            if (taskCounts[taskIndex] > maxTaskCount) {
                maxTaskCount = taskCounts[taskIndex];
                maxTaskCountFrequency = 1;
            } else if (taskCounts[taskIndex] == maxTaskCount) {
                maxTaskCountFrequency++;
            }
        }

        int idleSlots = (maxTaskCount - 1) * // -1 because the last task doesn't need idle slots
                        (n + 1); // +1 because we need slot for itself as well

        int totalSlots = idleSlots + maxTaskCountFrequency;

        return Math.max(tasks.length, totalSlots);
    }

}