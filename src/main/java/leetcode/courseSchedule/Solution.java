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

    // Time: O(n)
    // Space: O(n)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create a map to store the prerequisites for each course.
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            preMap.putIfAbsent(prerequisite[0], new ArrayList<>());
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] visited = new int[numCourses];

        // 0: The course has not been visited yet.
        // 1: The course has been visited and there is no cycle.
        // 2: The course is currently being visited and there is a cycle.

        // Perform a depth-first search on the graph starting from each course.
        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == 0 &&
                cycleDetected(preMap, visited, course)) {
                return false;
            }
        }

        // If all of the courses have been visited without finding a cycle, then all of the courses can be completed.
        return true;
    }

    private boolean cycleDetected(Map<Integer, List<Integer>> preMap, int[] visited, int course) {
        // If the course is currently being visited, then there is a cycle.
        if (visited[course] == 2) {
            return true;
        }

        // If the course has no prerequisites, then there is no cycle.
        if (!preMap.containsKey(course)) {
            return false;
        }

        // Mark the course as currently being visited.
        visited[course] = 2;

        // Recursively perform a depth-first search on all of the prerequisites of the course.
        for (int prerequisite : preMap.get(course)) {
            if (cycleDetected(preMap, visited, prerequisite)) {
                return true;
            }
        }

        // Remove the course from the set of courses that are currently being visited.
        visited[course] = 1;

        // Return false to indicate that no cycle was found.
        return false;
    }

}
