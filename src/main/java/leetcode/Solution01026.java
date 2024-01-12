package leetcode;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1026. Maximum Difference Between Node and Ancestor
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 * #medium
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 * <p>
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 * Example 2:
 * <p>
 * Input: root = [1,null,2,null,0,3]
 * Output: 3
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [2, 5000].
 * 0 <= Node.val <= 105
 */
public class Solution01026 {

    public static void main(String[] args) {
        Solution01026 s = new Solution01026();
        System.out.println(s.maxAncestorDiffDfs(new TreeNode(8, new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))), new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)))));
        System.out.println(s.maxAncestorDiffDfs(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null))))); // 3
    }

    // Time O(n)
    // Space O(n)
    public int maxAncestorDiffDfs(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        return Math.max(dfs(root.left, min, max), dfs(root.right, min, max));
    }

    // Time O(n)
    // Space O(n)
    public int maxAncestorDiffBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        Queue<QueueData> queue = new LinkedList<>();
        queue.add(new QueueData(root, root.val, root.val));

        while (!queue.isEmpty()) {
            QueueData current = queue.poll();
            max = Math.max(max, current.max - current.min);

            if (current.node.left != null) {
                queue.add(new QueueData(current.node.left, Math.min(current.min, current.node.left.val), Math.max(current.max, current.node.left.val)));
            }

            if (current.node.right != null) {
                queue.add(new QueueData(current.node.right, Math.min(current.min, current.node.right.val), Math.max(current.max, current.node.right.val)));
            }
        }

        return max;
    }

    private static class QueueData {
        TreeNode node;
        int min;
        int max;

        public QueueData(TreeNode node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

}
