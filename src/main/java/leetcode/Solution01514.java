package leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1514. Path with Maximum Probability
 * <a href="https://leetcode.com/problems/path-with-maximum-probability">Web link</a> |
 * Medium
 */

public class Solution01514 {
    public double maxProbabilityTLE(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] prob = new double[n];
        prob[start_node] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0], v = edges[j][1];
                double w = succProb[j];
                prob[v] = Math.max(prob[v], prob[u] * w);
                prob[u] = Math.max(prob[u], prob[v] * w);
            }
        }
        return prob[end_node];
    }

    public double maxProbabilityGreedyDijkstra(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair<Integer, Double>>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) adjacencyList.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int[] currentEdge = edges[i];
            adjacencyList.get(currentEdge[0]).add(new Pair<>(currentEdge[1], succProb[i]));
            adjacencyList.get(currentEdge[1]).add(new Pair<>(currentEdge[0], succProb[i]));
        }

        PriorityQueue<Pair<Integer, Double>> q = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
        double[] curr_prob = new double[n];
        curr_prob[start_node] = 1;
        q.offer(new Pair<>(start_node, 1.0));
        while (!q.isEmpty()) {
            Pair<Integer, Double> pair = q.poll();
            int node = pair.getKey();
            double prob = pair.getValue();
            if (node == end_node) return prob;

            for (Pair<Integer, Double> neighbor : adjacencyList.get(node)) {
                int neighborNode = neighbor.getKey();
                double neighborProb = neighbor.getValue();
                if (curr_prob[neighborNode] < neighborProb * prob) {
                    curr_prob[neighborNode] = neighborProb * prob;
                    q.offer(new Pair<>(neighborNode, neighborProb * prob));
                }
            }
        }

        return 0.0;
    }
}