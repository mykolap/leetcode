/**
 * 2583. Kth Largest Sum in a Binary Tree
 * <a href="https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree">Web link</a> |
 * Medium
 */

package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution02583 {

    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> results = new PriorityQueue<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            long sum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (results.size() < k) {
                results.offer(sum);
            } else {
                if (sum > results.peek()) {
                    results.poll();
                    results.offer(sum);
                }
            }
        }

        if (k > results.size()) {
            return -1;
        }

        return results.peek();
    }

}