package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2709. Greatest Common Divisor Traversal
 * https://leetcode.com/problems/greatest-common-divisor-traversal/
 */

public class Solution02709 {

    // Time: O(n * log(n))
    // Space: O(n)
    public boolean canTraverseAllPairs(int[] nums) {
        final int n = nums.length;
        UnionFind uf = new UnionFind(n);

        Map<Integer, Integer> factorIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int f = 2;
            while (f * f <= num) {
                if (num % f == 0) {
                    if (factorIndex.containsKey(f)) {
                        uf.union(i, factorIndex.get(f));
                    } else {
                        factorIndex.put(f, i);
                    }
                    while (num % f == 0) {
                        num /= f;
                    }
                }
                f++;
            }
            if (num > 1) {
                if (factorIndex.containsKey(num)) {
                    uf.union(i, factorIndex.get(num));
                } else {
                    factorIndex.put(num, i);
                }
            }
        }
        return uf.count == 1;
    }

    static class UnionFind {
        private final int[] parent;
        private final int[] size;
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
            count = n;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            count--;
        }
    }

}