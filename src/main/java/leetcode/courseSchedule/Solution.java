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
        // Create an adjacency list to represent the prerequisites graph.
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Add the prerequisites to the adjacency list.
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        // Create an array to track the status of each course.
        int[] visited = new int[numCourses];

        // Recursively check for cycles in the prerequisites graph.
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (isCyclic(adj, visited, i)) {
                    return false;
                }
            }
        }

        // If all of the courses have been visited without finding a cycle, then all of the courses can be completed.
        return true;
    }

    private boolean isCyclic(List<List<Integer>> adj, int[] visited, int curr) {
        // If the course is currently being visited and there is a cycle, then return true.
        if (visited[curr] == 2) {
            return true;
        }

        // Mark the course as currently being visited.
        visited[curr] = 2;

        // Recursively check for cycles in the prerequisites graph for all of the prerequisites of the current course.
        for (int i = 0; i < adj.get(curr).size(); i++) {
            if (visited[adj.get(curr).get(i)] != 1) {
                if (isCyclic(adj, visited, adj.get(curr).get(i))) {
                    return true;
                }
            }
        }

        // Mark the course as visited without a cycle.
        visited[curr] = 1;

        // Return false to indicate that no cycle was found.
        return false;
    }

}
