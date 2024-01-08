package leetcode.countGoodNodesInBinaryTree;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * 1448. Count Good Nodes in Binary Tree
 * Medium
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a
 * value greater than X.
 * Return the number of good nodes in the binary tree.
 * Example 1:
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 * Example 2:
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 * Example 3:
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 * Constraints:
 * The number of nodes in the binary tree is in the range [1, 10^5].
 * Each node's value is between [-10^4, 10^4].
 */
public class Solution1448 {

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
