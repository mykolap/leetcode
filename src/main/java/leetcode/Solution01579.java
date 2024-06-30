package leetcode;

import java.util.Arrays;

/**
 * 1579. Remove Max Number of Edges to Keep Graph Fully Traversable
 * https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
 * Hard
 */

public class Solution01579 {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // Create UnionFind instances for Alice and Bob
        UnionFind unionFindAlice = new UnionFind(n);
        UnionFind unionFindBob = new UnionFind(n);

        // Initialize the count of connections needed to keep the graph fully traversable
        int requiredConnectionsCount = 0;

        // First loop: Process type 3 edges
        for (int[] edge : edges) {
            int edgeType = edge[0]; // Type of the edge
            int node1 = edge[1]; // First node of the edge
            int node2 = edge[2]; // Second node of the edge

            // If the edge type is 3, it can be traversed by both Alice and Bob
            if (edgeType == 3) {
                // Try to connect the nodes in both UnionFind instances
                final boolean isAliceConnected = unionFindAlice.unionAndCheckConnectionRequired(node1, node2);
                final boolean isBobConnected = unionFindBob.unionAndCheckConnectionRequired(node1, node2);

                // If either Alice or Bob can traverse the edge, increment the count of required connections
                if (isAliceConnected || isBobConnected) {
                    ++requiredConnectionsCount;
                }
            }
        }

        // Second loop: Process type 1 and type 2 edges
        for (int[] edge : edges) {
            int edgeType = edge[0]; // Type of the edge
            int node1 = edge[1]; // First node of the edge
            int node2 = edge[2]; // Second node of the edge

            // If the edge type is 2, it can only be traversed by Bob
            if (edgeType == 2) {
                // If Bob can traverse the edge, increment the count of required connections
                if (unionFindBob.unionAndCheckConnectionRequired(node1, node2)) {
                    ++requiredConnectionsCount;
                }
            }
            // If the edge type is 1, it can only be traversed by Alice
            else if (edgeType == 1) {
                // If Alice can traverse the edge, increment the count of required connections
                if (unionFindAlice.unionAndCheckConnectionRequired(node1, node2)) {
                    ++requiredConnectionsCount;
                }
            }
        }

        // If both Alice and Bob can traverse the entire graph, return the number of edges that can be removed
        // Else, return -1 indicating that the graph cannot be fully traversed by both Alice and Bob
        if (unionFindAlice.isConnected() && unionFindBob.isConnected()) {
            return edges.length - requiredConnectionsCount;
        } else {
            return -1;
        }

    }

    static class UnionFind {
        int[] parent;
        int[] size;
        int count;

        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            size = new int[n + 1];
            Arrays.fill(size, 1);
            count = n;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean unionAndCheckConnectionRequired(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            count--;
            return true;
        }

        boolean isConnected() {
            return count == 1;
        }
    }

}