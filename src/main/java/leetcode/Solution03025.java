package leetcode;

/**
 * https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i
 * 3025. Find the Number of Ways to Place People I
 * Medium
 * <p>
 * You are given a 2D array points of size n x 2 representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 * <p>
 * We define the right direction as positive x-axis (increasing x-coordinate) and the left direction as negative x-axis (decreasing x-coordinate). Similarly, we define the up direction as positive y-axis (increasing y-coordinate) and the down direction as negative y-axis (decreasing y-coordinate)
 * <p>
 * You have to place n people, including Chisato and Takina, at these points such that there is exactly one person at every point. Chisato wants to be alone with Takina, so Chisato will build a rectangular fence with Chisato's position as the upper left corner and Takina's position as the lower right corner of the fence (Note that the fence might not enclose any area, i.e. it can be a line). If any person other than Chisato and Takina is either inside the fence or on the fence, Chisato will be sad.
 * <p>
 * Return the number of pairs of points where you can place Chisato and Takina, such that Chisato does not become sad on building the fence.
 * <p>
 * Note that Chisato can only build a fence with Chisato's position as the upper left corner, and Takina's position as the lower right corner. For example, Chisato cannot build either of the fences in the picture below with four corners (1, 1), (1, 3), (3, 1), and (3, 3), because:
 * <p>
 * With Chisato at (3, 3) and Takina at (1, 1), Chisato's position is not the upper left corner and Takina's position is not the lower right corner of the fence.
 * With Chisato at (1, 3) and Takina at (1, 1), Takina's position is not the lower right corner of the fence.
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 0
 * Explanation: There is no way to place Chisato and Takina such that Chisato can build a fence with Chisato's position as the upper left corner and Takina's position as the lower right corner. Hence we return 0.
 * Example 2:
 * <p>
 * Input: points = [[6,2],[4,4],[2,6]]
 * Output: 2
 * Explanation: There are two ways to place Chisato and Takina such that Chisato will not be sad:
 * - Place Chisato at (4, 4) and Takina at (6, 2).
 * - Place Chisato at (2, 6) and Takina at (4, 4).
 * You cannot place Chisato at (2, 6) and Takina at (6, 2) because the person at (4, 4) will be inside the fence.
 * Example 3:
 * <p>
 * Input: points = [[3,1],[1,3],[1,1]]
 * Output: 2
 * Explanation: There are two ways to place Chisato and Takina such that Chisato will not be sad:
 * - Place Chisato at (1, 1) and Takina at (3, 1).
 * - Place Chisato at (1, 3) and Takina at (1, 1).
 * You cannot place Chisato at (1, 3) and Takina at (3, 1) because the person at (1, 1) will be on the fence.
 * Note that it does not matter if the fence encloses any area, the first and second fences in the image are valid.
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 50
 * points[i].length == 2
 * 0 <= points[i][0], points[i][1] <= 50
 * All points[i] are distinct.
 */
public class Solution03025 {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int totalValid = 0;

        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];

            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                boolean valid = checkPointGood(points, p1, p2);
                if (valid) {
                    totalValid++;
                } else {
                    boolean isValid2 = checkPointGood(points, p2, p1);
                    if (isValid2) {
                        totalValid++;
                    }
                }
            }
        }

        return totalValid;
    }

    private static boolean checkPointGood(int[][] points, int[] p1, int[] p2) {
        int p1x = p1[0];
        int p1y = p1[1];

        int p2x = p2[0];
        int p2y = p2[1];
        if ((p1x > p2x && p1y < p2y) || // diagonal left top to right bottom
            (p1x > p2x && p1y == p2y) || // horizontal left to right
            (p1x == p2x && p1y < p2y)) { // vertical top to bottom
            boolean isInside = false;
            for (int[] p : points) {
                int px = p[0];
                int py = p[1];
                if (p != p1 && p != p2 &&
                    px >= p2x && px <= p1x && // x is between p1 and p2
                    py <= p2y && py >= p1y) { // y is between p1 and p2
                    isInside = true;
                    break;
                }
            }
            return !isInside;
        }
        return false;
    }

}