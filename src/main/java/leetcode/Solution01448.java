package leetcode;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * 1448. Count Good Nodes in Binary Tree
 * Medium
 */
public class Solution01448 {

    // Time O(n)
    // Space O(n)
    public int goodNodesDfs(TreeNode root) {
        return goodNodesDfs(root, Integer.MIN_VALUE);
    }

    private int goodNodesDfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.val >= max) {
            count++;
        }

        count += goodNodesDfs(root.left, Math.max(max, root.val));
        count += goodNodesDfs(root.right, Math.max(max, root.val));

        return count;
    }

    public int goodNodesBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, root.val));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int max = pair.max;

            if (node.val >= max) {
                count++;
            }

            max = Math.max(max, node.val);

            if (node.left != null) {
                queue.add(new Pair(node.left, max));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, max));
            }
        }

        return count;
    }

    // Pair class to store a node and the maximum value in its path from the root
    private static class Pair {
        TreeNode node;
        int max;

        Pair(TreeNode node, int max) {
            this.node = node;
            this.max = max;
        }
    }

}
