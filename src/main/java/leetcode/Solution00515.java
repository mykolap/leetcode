/**
 * 515. Find Largest Value in Each Tree Row
 * <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row">Web link</a>
 * Medium
 */

package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution00515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        levelTraversal(List.of(root), result);
        return result;
    }

    private void levelTraversal(List<TreeNode> levelNodes, List<Integer> result) {
        if (levelNodes.isEmpty()) {
            return;
        }
        int max = Integer.MIN_VALUE;
        List<TreeNode> nextLevelNodes = new ArrayList<>();
        for (TreeNode node : levelNodes) {
            max = Math.max(max, node.val);
            if (node.left != null) {
                nextLevelNodes.add(node.left);
            }
            if (node.right != null) {
                nextLevelNodes.add(node.right);
            }
        }
        result.add(max);
        levelTraversal(nextLevelNodes, result);
    }

}