package leetcode;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * 938. Range Sum of BST
 * Easy
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 * Example 1:
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Example 2:
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * Constraints:
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 */
public class Solution00938 {

    // Time O(n)
    // Space O(n)
    public int rangeSumBstBfs(TreeNode root, int low, int high) {
        int sum = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.val >= low && curr.val <= high) {
                sum += curr.val;
            }

            if (curr.left != null && curr.val > low) {
                queue.add(curr.left);
            }

            if (curr.right != null && curr.val < high) {
                queue.add(curr.right);
            }
        }

        return sum;
    }

    // Time O(n)
    // Space O(n)
    public int rangeSumBstDfs(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        if (root.val > low) {
            sum += rangeSumBstDfs(root.left, low, high);
        }

        if (root.val < high) {
            sum += rangeSumBstDfs(root.right, low, high);
        }

        return sum;
    }

}
