package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/
 * 207. Course Schedule
 * Medium
 */
public class Solution00207 {

    // Time complexity: O(V + E)
    // Space complexity: O(V)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create a map to store the prerequisites for each course.
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Create an array to store the in-degree of each course.
        int[] inDegree = new int[numCourses];

        // Iterate over all of the prerequisites and add them to the map and the in-degree array.
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];

            graph.computeIfAbsent(prerequisiteCourse, k -> new ArrayList<>()).add(course);
            inDegree[course]++;
        }

        // Create a queue to store the courses that have no prerequisites.
        Queue<Integer> queue = new LinkedList<>();

        // Add all of the courses that have no prerequisites to the queue.
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Initialize a counter to track the number of courses that have been completed.
        int count = 0;

        // While the queue is not empty, do the following:
        while (!queue.isEmpty()) {

            // Remove a course from the queue.
            int course = queue.poll();

            // Increment the counter.
            count++;

            // Iterate over all of the prerequisites of the course.
            if (graph.containsKey(course)) {
                for (int nextCourse : graph.get(course)) {

                    // Decrement the in-degree of the prerequisite course.
                    inDegree[nextCourse]--;

                    // If the in-degree of the prerequisite course is now 0, then add it to the queue.
                    if (inDegree[nextCourse] == 0) {
                        queue.add(nextCourse);
                    }
                }
            }
        }

        // If all of the courses have been completed, then return true. Otherwise, return false.
        return count == numCourses;
    }

}
