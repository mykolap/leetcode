package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1992. Find All Groups of Farmland
 * Source: https://leetcode.com/problems/find-all-groups-of-farmland/
 * Medium
 */

public class Solution01992 {

    public int[][] findFarmland(int[][] land) {
        List<int[]> farmlands = new ArrayList<>();
        int rows = land.length;
        int cols = land[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // If the current cell is 1, then it is the top-left corner of a farmland
                if (land[row][col] == 1) {
                    int farmlandLastRow = row;
                    int farmlandLastCol = col;
                    // Find the bottom-right corner of the farmland
                    while (farmlandLastRow < rows && land[farmlandLastRow][col] == 1) {
                        farmlandLastRow++;
                    }

                    while (farmlandLastCol < cols && land[row][farmlandLastCol] == 1) {
                        farmlandLastCol++;
                    }

                    farmlands.add(new int[]{row, col, farmlandLastRow - 1, farmlandLastCol - 1});
                    // Mark the farmland as visited
                    for (int k = row; k < farmlandLastRow; k++) {
                        for (int l = col; l < farmlandLastCol; l++) {
                            land[k][l] = 0;
                        }
                    }
                }
            }
        }
        return farmlands.toArray(new int[0][]);
    }

}