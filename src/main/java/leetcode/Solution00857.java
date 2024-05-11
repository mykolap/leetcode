package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 857. Minimum Cost to Hire K Workers
 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
 * Hard
 */

public class Solution00857 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(wage[i], quality[i]);
        }
        Arrays.sort(workers, Comparator.comparingDouble(a -> a.ratePerQuality));

        double result = Double.MAX_VALUE;
        int qualitySum = 0;
        Queue<Worker> qualityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.quality, a.quality));
        for (Worker worker : workers) {
            qualityQueue.add(worker);
            qualitySum += worker.quality;
            if (qualityQueue.size() == k) {
                final double biggestRateByNow = worker.ratePerQuality;
                final double resultCandidate = qualitySum * biggestRateByNow;
                result = Math.min(result, resultCandidate);
                Worker biggestQualityWorker = qualityQueue.poll();
                qualitySum -= biggestQualityWorker.quality;
            }
        }
        return result;
    }

    private static class Worker {
        double ratePerQuality;
        int quality;

        public Worker(int wage, int quality) {
            this.ratePerQuality = (double) wage / quality;
            this.quality = quality;
        }

        @Override
        public String toString() {
            return "Data{" +
                   "ratePerQuality=" + ratePerQuality +
                   ", quality=" + quality +
                   '}';
        }
    }

}