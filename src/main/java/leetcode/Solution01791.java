package leetcode;

/**
 * 1791. Find Center of Star Graph
 * <a href="https://leetcode.com/problems/find-center-of-star-graph">Web link</a> |
 * Easy
 */

public class Solution01791 {

    public int findCenter(int[][] edges) {
        int first = edges[0][0];
        int second = edges[0][1];
        int third = edges[1][0];
        if (third == first || third == second) {
            return third;
        }
        return edges[1][1]; // fourth
    }
}