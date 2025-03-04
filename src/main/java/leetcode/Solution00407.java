/**
 * 407. Trapping Rain Water II
 * <a href="https://leetcode.com/problems/trapping-rain-water-ii">Web link</a> |
 * Hard
 */

package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution00407 {

    public int trapRainWater(int[][] heightMap) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];

        // Add border cells
        for (int j = 0; j < n; j++) {
            pq.offer(new int[]{heightMap[0][j], 0, j});
            pq.offer(new int[]{heightMap[m - 1][j], m - 1, j});
            visited[0][j] = visited[m - 1][j] = true;
        }

        for (int i = 1; i < m - 1; i++) {
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][n - 1], i, n - 1});
            visited[i][0] = visited[i][n - 1] = true;
        }

        int water = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int height = curr[0];
            int row = curr[1];
            int col = curr[2];

            for (int k = 0; k < 4; k++) {
                int newRow = row + dx[k];
                int newCol = col + dy[k];

                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n ||
                        visited[newRow][newCol]) continue;

                if (heightMap[newRow][newCol] < height) {
                    water += height - heightMap[newRow][newCol];
                    pq.offer(new int[]{height, newRow, newCol});
                } else {
                    pq.offer(new int[]{heightMap[newRow][newCol], newRow, newCol});
                }
                visited[newRow][newCol] = true;
            }
        }
        return water;
    }

}