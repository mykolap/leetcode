package leetcode;

/**
 * 1701. Average Waiting Time
 * <a href="https://leetcode.com/problems/average-waiting-time">Web link</a> |
 * Medium
 */

public class Solution01701 {

    public double averageWaitingTime(int[][] customers) {
        long totalWaitTime = 0;
        long finishCooking = 0;

        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int cookingTime = customer[1];

            long startCooking = Math.max(finishCooking, arrivalTime);
            finishCooking = startCooking + cookingTime;

            totalWaitTime += finishCooking - arrivalTime;
        }

        return (double) totalWaitTime / customers.length;
    }

}