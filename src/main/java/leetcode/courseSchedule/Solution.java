package leetcode.courseSchedule;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/
 * 207. Course Schedule
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * <p>
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
 * that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * <p>
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * Example 2:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0,
 * and to take course 0 you should also have finished course 1. So it is impossible.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class Solution {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};

        System.out.println(new Solution().canFinish(numCourses, prerequisites));
    }

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
